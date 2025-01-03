package com.metacoding.web_project.report;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;


@Import(ReportRepository.class)
@DataJpaTest
public class ReportRepositoryTest {

    @Autowired
    private ReportRepository reportRepository;

//    @Test
//    public void findReportJoinAnotherInfo_test() {
//        List<Report> reportJoinAnotherInfo = reportRepository.findReportJoinAnotherInfo("where r.status = 0");
//        System.out.println(reportJoinAnotherInfo.get(0).getTransaction().getSeller().getName());
//        System.out.println(reportJoinAnotherInfo.get(0).getTransaction().getBuyer().getName());
//        System.out.println(reportJoinAnotherInfo.get(0).getTransaction().getGoods().getTitle());
//        System.out.println(reportJoinAnotherInfo.get(0).getReporter().getId());
//        System.out.println(reportJoinAnotherInfo.get(0).getTransaction().getSeller().getId());
//    }

    @Test
    public void findById_test() {
        Report byId = reportRepository.findById("1");
        System.out.println(byId.toString());
    }

    @Test
    public void count_test() {
        Integer reportCount = reportRepository.findReportCount("");
        Integer reportCount2 = reportRepository.findReportCount("waiting");
        System.out.println(reportCount);
        System.out.println(reportCount2);
    }

}
