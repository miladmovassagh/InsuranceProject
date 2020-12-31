package model.service;

import model.entity.ReportEntity;
import model.repository.ReportRepository;

public class ReportService {

    private static ReportService reportService = new ReportService();

    public static ReportService getInstance() {
        return reportService;
    }

    private ReportService() {

    }

    public void save(ReportEntity reportEntity) throws Exception {
        try(ReportRepository reportRepository = new ReportRepository()) {
            reportRepository.insert(reportEntity);
            reportRepository.commit();
        }
    }
}
