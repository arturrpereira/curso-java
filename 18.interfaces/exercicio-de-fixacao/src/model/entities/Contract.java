package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    
    private Integer number;
    private Date date;
    private Double totalValue;

    private List<Installment> installments = new ArrayList<>();
}
