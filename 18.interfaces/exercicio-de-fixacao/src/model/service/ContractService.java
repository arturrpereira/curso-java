package model.service;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;

    public ContractService() {

    }
    
    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        
        for(Integer i=1; i<= months; i++) {
            Double amount;
            amount = onlinePaymentService.interest(contract.getTotalValue()/months, i);
            contract.getInstallments().add(new Installment(contract.getDate(), amount));
        }
    }
}
