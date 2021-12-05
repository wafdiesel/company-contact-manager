package com.contactmanager.genesistest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.genesistest.dto.CompanyDto;
import com.contactmanager.genesistest.entities.Company;
import com.contactmanager.genesistest.mappers.CompanyMapper;
import com.contactmanager.genesistest.services.company.CompanyService;

@RestController
@RequestMapping(value = "/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/getCompanyByVat{vatNumber}")
    public List<CompanyDto> getCompanyByVat(@RequestParam(name="vatNumber") final String vatNumber) {
		List<CompanyDto> companyDtos = new ArrayList<>();
        final List<Company> companies = companyService.getCompanyByVat(vatNumber);
        companies.forEach(company -> companyDtos.add(CompanyMapper.mapComapyToDto(company)));
        return companyDtos;
    }

    @GetMapping("/getAllCompanies")
    public List<CompanyDto> getAllCompanies() {
		List<CompanyDto> companyDtos = new ArrayList<>();
		final List<Company> companies = companyService.getAllCompanies();
		companies.forEach(company -> companyDtos.add(CompanyMapper.mapComapyToDto(company)));
		return companyDtos;
    }

    @PostMapping("/createCompany")
    public CompanyDto createCompany(@Valid @RequestBody final CompanyDto newCompanyDto) {
        Company newComapny = CompanyMapper.mapDtoToCompany(newCompanyDto);
        return CompanyMapper.mapComapyToDto(companyService.createCompany(newComapny));
    }

    @PutMapping("/updateCompany")
    public void updateCompany(@Valid @RequestBody final CompanyDto companyUpdates) {
        companyService.updateCompany(CompanyMapper.mapDtoToCompany(companyUpdates));
    }

    @PostMapping("/addContactToCompany/{companyId}/contacts/{contactId}")
    public void addContactToCompany(@RequestParam(name="companyId") final Long companyId, @RequestParam(name="contactId") final Long contactId){
        companyService.addContact(companyId, contactId);
    }
}

