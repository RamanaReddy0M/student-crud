package in.one2n.ramana.entities;

public enum Gender {
    M("M"), F("F");

    private String gender;

    private Gender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }
}
