package ru.artur.model;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Aleksandr on 19.12.17.
 */
public class SourceData {

    private Property<Long> n = null;
    public Long getN() {
        return n.getValue();
    }
    public Property<Long> nProperty() {
        return n;
    }

    private Property<Double> d = null;
    public double getD() {
        return d.getValue();
    }
    public Property<Double> dProperty() {
        return d;
    }

    private Property<Double> z = null;
    public Double getZ() {
        return z.getValue();
    }
    public Property<Double> zProperty() {
        return z;
    }

    // ========================================================================================================== //
    // ИСХОДНЫЕ ДАННЫЕ
    // ========================================================================================================== //

    private DoubleProperty param1 = new SimpleDoubleProperty();       // T, сек
    public double getParam1() {
        return param1.get();
    }
    public DoubleProperty param1Property() {
        return param1;
    }
    public void setParam1(double param1) {
        this.param1.set(param1);
    }

    private DoubleProperty param1_future = new SimpleDoubleProperty();       // T, сек (окончание диапазона)
    public double getParam1_future() {
        return param1_future.get();
    }
    public DoubleProperty param1_futureProperty() {
        return param1_future;
    }
    public void setParam1_future(double param1_future) {
        this.param1_future.set(param1_future);
    }

    private DoubleProperty param1_step = new SimpleDoubleProperty();       // T, сек (шаг изменения диапазона)
    public double getParam1_step() {
        return param1_step.get();
    }
    public DoubleProperty param1_stepProperty() {
        return param1_step;
    }
    public void setParam1_step(double param1_step) {
        this.param1_step.set(param1_step);
    }

    private DoubleProperty param2 = new SimpleDoubleProperty();       // θ, сек
    public double getParam2() {
        return param2.get();
    }
    public DoubleProperty param2Property() {
        return param2;
    }
    public void setParam2(double param2) {
        this.param2.set(param2);
    }

    private DoubleProperty param2_future = new SimpleDoubleProperty();       // θ, сек (окончание диапазона)
    public double getParam2_future() {
        return param2_future.get();
    }
    public DoubleProperty param2_futureProperty() {
        return param2_future;
    }
    public void setParam2_future(double param2_future) {
        this.param2_future.set(param2_future);
    }

    private DoubleProperty param2_step = new SimpleDoubleProperty();       // θ, сек (шаг изменения диапазона)
    public double getParam2_step() {
        return param2_step.get();
    }
    public DoubleProperty param2_stepProperty() {
        return param2_step;
    }
    public void setParam2_step(double param2_step) {
        this.param2_step.set(param2_step);
    }

    private IntegerProperty param3 = new SimpleIntegerProperty();       // ω, бит/с
    public int getParam3() {
        return param3.get();
    }
    public IntegerProperty param3Property() {
        return param3;
    }
    public void setParam3(int param3) {
        this.param3.set(param3);
    }

    private IntegerProperty param4 = new SimpleIntegerProperty();       // τ, сек
    public int getParam4() {
        return param4.get();
    }
    public IntegerProperty param4Property() {
        return param4;
    }
    public void setParam4(int param4) {
        this.param4.set(param4);
    }

    private IntegerProperty param5 = new SimpleIntegerProperty();       // H tcp, бит
    public int getParam5() {
        return param5.get();
    }
    public IntegerProperty param5Property() {
        return param5;
    }
    public void setParam5(int param5) {
        this.param5.set(param5);
    }

    private IntegerProperty param6 = new SimpleIntegerProperty();       // H, бит
    public int getParam6() {
        return param6.get();
    }
    public IntegerProperty param6Property() {
        return param6;
    }
    public void setParam6(int param6) {
        this.param6.set(param6);
    }

    private IntegerProperty param7 = new SimpleIntegerProperty();       // H ip, бит
    public int getParam7() {
        return param7.get();
    }
    public IntegerProperty param7Property() {
        return param7;
    }
    public void setParam7(int param7) {
        this.param7.set(param7);
    }

    private DoubleProperty param8 = new SimpleDoubleProperty();         // p
    public double getParam8() {
        return param8.get();
    }
    public DoubleProperty param8Property() {
        return param8;
    }
    public void setParam8(double param8) {
        this.param8.set(param8);
    }

    private DoubleProperty param8_future = new SimpleDoubleProperty();         // p (окончание диапазона)
    public double getParam8_future() {
        return param8_future.get();
    }
    public DoubleProperty param8_futureProperty() {
        return param8_future;
    }
    public void setParam8_future(double param8_future) {
        this.param8_future.set(param8_future);
    }

    private DoubleProperty param8_step = new SimpleDoubleProperty();         // p (шаг изменения диапазона)
    public double getParam8_step() {
        return param8_step.get();
    }
    public DoubleProperty param8_stepProperty() {
        return param8_step;
    }
    public void setParam8_step(double param8_step) {
        this.param8_step.set(param8_step);
    }

    private IntegerProperty param9 = new SimpleIntegerProperty();       // V, бит
    public int getParam9() {
        return param9.get();
    }
    public IntegerProperty param9Property() {
        return param9;
    }
    public void setParam9(int param9) {
        this.param9.set(param9);
    }

    private IntegerProperty param10 = new SimpleIntegerProperty();      // υ, бит/с
    public int getParam10() {
        return param10.get();
    }
    public IntegerProperty param10Property() {
        return param10;
    }
    public void setParam10(int param10) {
        this.param10.set(param10);
    }

    private DoubleProperty param11 = new SimpleDoubleProperty();
    public double getParam11() {
        return param11.get();
    }
    public DoubleProperty param11Property() {
        return param11;
    }
    public void setParam11(double param11) {
        this.param11.set(param11);
    } // nu

    // ========================================================================================================== //
    // ВЫЧИСЛЯЕМЫЕ ДАННЫЕ
    // ========================================================================================================== //

    private DoubleProperty result2 = new SimpleDoubleProperty();
    public double getResult2() {
        return result2.get();
    }
    public DoubleProperty result2Property() {
        return result2;
    }

    private DoubleProperty result3 = new SimpleDoubleProperty();
    public double getResult3() {
        return result3.get();
    }
    public DoubleProperty result3Property() {
        return result3;
    }

    private DoubleProperty result4 = new SimpleDoubleProperty();
    public double getResult4() {
        return result4.get();
    }
    public DoubleProperty result4Property() {
        return result4;
    }

    private DoubleProperty result5 = new SimpleDoubleProperty();
    public double getResult5() {
        return result5.get();
    }
    public DoubleProperty result5Property() {
        return result5;
    }

    private DoubleProperty result6 = new SimpleDoubleProperty();
    public double getResult6() {
        return result6.get();
    }
    public DoubleProperty result6Property() {
        return result6;
    }

    private DoubleProperty result7 = new SimpleDoubleProperty();
    public double getResult7() {
        return result7.get();
    }
    public DoubleProperty result7Property() {
        return result7;
    }

    private DoubleProperty result8 = new SimpleDoubleProperty();
    public double getResult8() {
        return result8.get();
    }
    public DoubleProperty result8Property() {
        return result8;
    }

    private DoubleProperty result9 = new SimpleDoubleProperty();
    public double getResult9() {
        return result9.get();
    }
    public DoubleProperty result9Property() {
        return result9;
    }

    private DoubleProperty result10 = new SimpleDoubleProperty();
    public double getResult10() {
        return result10.get();
    }
    public DoubleProperty result10Property() {
        return result10;
    }

    private DoubleProperty result11 = new SimpleDoubleProperty();
    public double getResult11() {
        return result11.get();
    }
    public DoubleProperty result11Property() {
        return result11;
    }

    private DoubleProperty result12 = new SimpleDoubleProperty();
    public double getResult12() {
        return result12.get();
    }
    public DoubleProperty result12Property() {
        return result12;
    }

    private DoubleProperty result13 = new SimpleDoubleProperty();
    public double getResult13() {
        return result13.get();
    }
    public DoubleProperty result13Property() {
        return result13;
    }

    // ========================================================================================================== //
    // КОНСТРУКТОР КЛАССА
    // ========================================================================================================== //

    public SourceData(long n, double d, double z) {
        this.n = new ReadOnlyObjectWrapper<>(n);
        this.d = new ReadOnlyObjectWrapper<>(d);
        this.z = new ReadOnlyObjectWrapper<>(z);
    }

    // ========================================================================================================== //
    // ВЫЧИСЛЕНИЯ
    // ========================================================================================================== //

    public void calculate() throws Exception {
        result2.set(calculateResult2());
        result3.set(calculateResult3());
        result4.set(calculateResult4());
        result5.set(calculateResult5());
        result6.set(calculateResult6());
        result7.set(calculateResult7());
        result8.set(calculateResult8());
        result9.set(calculateResult9());
        result10.set(calculateResult10());
        result11.set(calculateResult11());
        result12.set(calculateResult12());
        result13.set(calculateResult13());
        // TODO: вставить формулы
    }

    public void clear() {
        param1.set(0);
        param2.set(0);
        param3.set(0);
        param4.set(0);
        param5.set(0);
        param6.set(0);
        param7.set(0);
        param8.set(0);
        param9.set(0);
        param10.set(0);

        result2.set(0);
        result3.set(0);
        result4.set(0);
        result5.set(0);
        result6.set(0);
        result7.set(0);
        result8.set(0);
        result9.set(0);
        result10.set(0);
        result11.set(0);
        result12.set(0);
        result13.set(0);
    }

    private double calculateResult2() throws Exception {
        final double alfa = Math.sqrt( (getParam7() + getParam6()) * getParam9() / getZ() * getParam2() );
        return ( (getParam2() * getParam10() + getParam7()) * alfa - getParam6() * getParam10()) / ( alfa + getParam10() );
    }

    private double calculateResult3() throws Exception {
        final double beta = (((getParam2() * getParam9()) / (getResult2() + getParam6()) ) - ((getResult2() - getParam7()) / (getResult2() + getParam6()) * (getParam9() / getParam10()) )  );
        return (1-getZ()/beta);
    }

    private double calculateResult4() throws Exception {
        if ((getResult3() <= 1) && (getResult3() > 0)) {
            return ((((getResult2() - getParam7()) * getParam9()) / (getParam11() * (getResult2() + getParam6()) * getParam10())) * getResult3());
        } else {
            result2.set(getParam6());
            return 0;
        }
    }

    private double calculateResult5() throws Exception {
        if (getResult4() == 0 ) { result3.set(0);}
            final double c = (getParam1() * getParam9() * (1 - getResult3()) - getN() * (getResult2() + getParam5() + getParam7() + getParam6()) * (getResult3() / (1 - getResult3())) - getN() * (getParam5() + getParam7() + getParam6())) * (getParam5() + getParam7() + getParam6());
            final double g = (getN() + (((1 - getResult3()) / getParam3()) * getParam9())) * (getParam5() + getParam7() + getParam6());
            final double a3 = ((getN() + ((1 - getResult3()) / getParam3() * getParam9()))
                    * (1 - ((getParam5() + getParam7() + getParam6()) * (1 / (getParam1() * getParam3())))))
                    - (getParam1() * getParam9() * (1 - getResult3()) -
                    getN() * (getResult2() + getParam5() + getParam7() + getParam6()) *
                            (getResult3() / (1 - getResult3())) -
                    getN() * (getParam5() + getParam7() + getParam6()))
                    * (1 / (getParam1() * getParam3()));
            return ((-g + Math.sqrt((g * g) + a3 * Math.abs(c))) / a3) + getParam5();


    }

    private double calculateResult6() throws Exception {
        DecimalFormat df2 = new DecimalFormat("0.00000");
        double s = (1  - getParam8()) + 0.009;
        final String x = df2.format(s);
        s = df2.parse(x).doubleValue();
        final double p0=Math.pow(s , (getResult5() + getParam6()));
        return -(p0/(1 - p0)) * Math.log(p0);
    }

    private double calculateResult7() throws Exception {
        return 1 - getResult3() -((getResult5() + getParam6()) / (getResult6() * getParam9() * getParam1()))
                - ((getResult3() / (1 - getResult3()) * ((getResult2() + getParam6() ) / (getParam1() *getParam9()) ))) ;
    }

    private double calculateResult8() throws Exception {
        double x = (double) getParam10();
        double y = (double) getParam9();
        double z = ((getResult2() + getParam6())/(getResult2() - getParam7()) * (x / y ) * getResult4() * getParam11()) ;
        return z;
    }

    private double calculateResult9() throws Exception {
        final double c = (getParam1() * getParam9() * (1 - getResult8()) - getN() * (getResult2() + getParam5() + getParam7() + getParam6()) * (getResult8() / (1 - getResult8())) - getN() * (getParam5() + getParam7() + getParam6())) * (getParam5() + getParam7() + getParam6());
        final double g = (getN() + (((1 - getResult8()) / getParam3()) * getParam9())) * (getParam5() + getParam7() + getParam6());
        final double a3 = ((getN() + ((1 - getResult8()) / getParam3() * getParam9() ))
                * (1 - ((getParam5() + getParam7() + getParam6()) * (1 / (getParam1() * getParam3())))))
                - (getParam1() * getParam9() * (1 - getResult8()) -
                getN() * (getResult2() + getParam5() + getParam7() + getParam6()) *
                        (getResult8() /(1 - getResult8()) ) -
                getN() * (getParam5()+ getParam7() +getParam6()))
                * (1 / (getParam1() * getParam3()));
        return ((-g + Math.sqrt((g * g) + a3 * Math.abs(c))) / a3) + getParam5();
    }

    private double calculateResult10() throws Exception {
        return 1 - getResult8() -((getResult5() + getParam6()) / (getResult6() * getParam9() * getParam1()))
                - ((getResult8() / (1 - getResult8()) * ((getResult2() + getParam6() ) / (getParam1() * getParam9()) ))) ;
    }

    private double calculateResult11() throws Exception {
        if(getResult9() == getParam6()) {
            return 0;
        }
        else {
            return getParam9() * (((getResult9() - getParam7()) * getResult10()) / (getResult9() + getParam5() + getParam6()));
        }
    }

    private double calculateResult12() throws Exception {
        return getParam9() * (((getResult2() - getParam7()) * getResult8()) / (getResult2() + getParam5() + getParam6()));
    }

    private double calculateResult13() throws Exception {
        return ( (getResult12() * (1 - getD()) + getResult11()) / getParam9() );
    }
}
