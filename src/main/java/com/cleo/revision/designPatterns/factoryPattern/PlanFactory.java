package com.cleo.revision.designPatterns.factoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanFactory {

    public Plan getPlan(String planType){
        if(planType == null)
            return null;
        if(planType.equalsIgnoreCase("DOMESTICPLAN"))
            return new DomesticPlan();
        else if(planType.equalsIgnoreCase("INSTITUITIONALPLAN"))
            return new InstitutionalPlan();
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN"))
            return new CommercialPlan();
        return null;
    }



    public static void main(String[] args) throws IOException {
        PlanFactory planFactory = new PlanFactory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planName = reader.readLine();
        int units = Integer.parseInt(reader.readLine());
        Plan plan = planFactory.getPlan(planName);
        System.out.println("Bill amount for " + planName + " of" + units + " is ");
        plan.getRate();
        plan.calculateBill(units);
    }
}
