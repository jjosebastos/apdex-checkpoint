package org.example;

import java.text.DecimalFormat;

public class Apdex {

    public float calcApdex(Integer satisfatorios, Integer toleravel, Integer total){
        return (float) (satisfatorios + (toleravel / 2)) /total;
    }

    public String checkApdex(Float apdxCalc) {
        if (apdxCalc >= 0.94 && apdxCalc <= 1) {
            return "Excelente";
        } else if (apdxCalc >= 0.85 && apdxCalc <= 0.93) {
            return "Bom";
        } else if (apdxCalc >= 0.70 && apdxCalc <= 0.84) {
            return "Razoavel";
        } else if (apdxCalc >= 0.50 && apdxCalc <= 0.69) {
            return "Ruim";
        } else {
            return "Inaceitavel";
        }
    }

}
