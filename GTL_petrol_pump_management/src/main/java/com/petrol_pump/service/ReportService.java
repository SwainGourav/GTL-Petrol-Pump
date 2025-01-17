package com.petrol_pump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrol_pump.entity.Report;
import com.petrol_pump.repository.ReportRepository;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;

    public List<Report> getAllReports() {
        return repository.findAll();
    }

    public Report getReportById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Report saveReport(Report report) {
        return repository.save(report);
    }

    public Report updateReport(Long id, Report reportDetails) {
        Report report = repository.findById(id).orElse(null);
        if (report != null) {
            report.setDate(reportDetails.getDate());
            report.setTotalPetrolDispensed(reportDetails.getTotalPetrolDispensed());
            report.setTotalSales(reportDetails.getTotalSales());
            report.setPetrolUsedForTesting(reportDetails.getPetrolUsedForTesting());
            report.setTotalAmountEarned(reportDetails.getTotalAmountEarned());
            report.setTotalFuelConsumedForTesting(reportDetails.getTotalFuelConsumedForTesting());
            report.setTotalFuelDispensed(reportDetails.getTotalFuelDispensed());
            return repository.save(report);
        }
        return null;
    }

    public void deleteReport(Long id) {
        repository.deleteById(id);
    }
}
