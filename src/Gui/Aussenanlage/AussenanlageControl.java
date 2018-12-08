package Gui.Aussenanlage;

public final class AussenanlageControl {
    private AussenanlageView aussenanlageControl;
    private double preis;



    public AussenanlageControl() { this.aussenanlageControl = new AussenanlageView(this);}

    public void oeffneAussenanlageView(){this.aussenanlageControl.setVisible(true);}

    public void leseAussenanlageSonderwuensche(){}

    public boolean pruefeKonstellationSonderwuensche(int [] ausgewaehlteSw) { return true;}

    public double berechnePreis(){
        preis = 0;
        if(aussenanlageControl.chckBxEGAbstellraumTerrasse.isSelected() == true){
            preis += 3590;
        }
        if(aussenanlageControl.chckBxVorbereitungEleAntriebe.isSelected() == true){
            preis += 170;
        }
        if(aussenanlageControl.chckBxDGVorbereitungEleAntriebe.isSelected() == true){
            preis += 170;
        }
        if(aussenanlageControl.chckBxEGElektrischeMarkise.isSelected() == true){
            preis += 890;
        }
        if(aussenanlageControl.chckBxDGElektrischeMarkise.isSelected() == true){
            preis += 890;
        }
        if(aussenanlageControl.chckBxEleAntriebGaragentor.isSelected() == true){
            preis += 990;
        }
        if(aussenanlageControl.chckBxSektionaltor.isSelected() == true){
            preis += 790;
        }
        return preis;
    }



}
