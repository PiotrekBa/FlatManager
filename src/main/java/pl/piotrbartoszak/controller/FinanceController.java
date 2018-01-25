package pl.piotrbartoszak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piotrbartoszak.model.*;
import pl.piotrbartoszak.repository.FinanceRepository;
import pl.piotrbartoszak.repository.FlatRepository;
import pl.piotrbartoszak.repository.OwnerRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/finances")
public class FinanceController {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    FlatRepository flatRepository;

    @Autowired
    FinanceRepository financeRepository;

    @GetMapping("/owner/{id}")
    public List<List<FinanceDetailsView>> showAllByUser(@PathVariable long id) {
        Owner owner = ownerRepository.findOne(id);
        List<Flat> flats = flatRepository.findEnableByOwnerId(owner.getId());
        List<List<FinanceDetailsView>> finances = new ArrayList<>();
        for (Flat flat : flats) {
            List<Finance> finances1 = financeRepository.findByFlat(flat.getId());
            List<FinanceDetailsView> financeDetailsViewList = new ArrayList<>();
            for (Finance f : finances1) {
                FinanceDetailsView fdv = FinanceDetailsView.fromFinance(f);
                fdv.setFlatName(flat.getName());
                financeDetailsViewList.add(fdv);
            }
            finances.add(financeDetailsViewList);
        }
        return finances;
    }

//    @GetMapping("/owner/{id}")
//    public MonthlyFinancialSummaryView showAllByUser(@PathVariable long id) {
//        Owner owner = ownerRepository.findOne(id);
//        List<Flat> flats = flatRepository.findEnableByOwnerId(owner.getId());
//        List<List<FinanceDetailsView>> finances = new ArrayList<>();
//        for (Flat flat : flats) {
//            List<Finance> finances1 = financeRepository.findByFlat(flat.getId());
//            List<FinanceDetailsView> financeDetailsViewList = new ArrayList<>();
//            for (Finance f : finances1) {
//                FinanceDetailsView fdv = FinanceDetailsView.fromFinance(f);
//                fdv.setFlatName(flat.getName());
//                financeDetailsViewList.add(fdv);
//            }
//            finances.add(financeDetailsViewList);
//        }
//        MonthlyFinancialSummaryView mfsv = new MonthlyFinancialSummaryView();
//        mfsv.setFinances(finances);
//
//        int turnover = 0;
//        int maxPossible;
//        for (Flat flat : flats) {
//         //liczysz turnover
//        }
//
//
//        mfsv.setTurnover(turnover);
//        return finances;
//    }

    @GetMapping("/incomes")
    public Turnover getIncomes() {
        List<Flat> flats = flatRepository.findEnableByOwnerId(1l);
        int actualTurnover = 0;
        int possibleTurnover = 0;
        for (Flat f : flats) {
            List<Room> rooms = f.getRooms();
            for (Room r : rooms) {
                possibleTurnover += r.getRent();
                if (r.getTenant().size() != 0) {
                    actualTurnover += r.getRent();
                }
            }
        }
        Turnover turnover = new Turnover(actualTurnover, possibleTurnover);
        return turnover;
    }


}
