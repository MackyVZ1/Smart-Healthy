public class UserInfo extends Calculating {
    private String name;
    private int age;
    private double height;
    private double weight;
    private String gender;
    public static int numOfUser = 0;

    public UserInfo(){

    }
    
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
    /**
     * @return Amount of water
     */
    @Override
    public double calculateWater(){
        return (getHeight()/10.0) * 0.4; 
    }
    /**
     * 
     * @return BMR for a male
     */
    @Override
    public double calculateBMRmale(){
        return 66 + (13.7 * getWeight() + (5 * getHeight()) -(6.8 * getAge()));
    }

    /**
     * 
     * @return BMR for a female
     */
    @Override
    public double calculateBMRfemale(){
        return 665 + (9.6 * getWeight()) + (1.8 * getHeight()) - (4.7 * getAge());
    }

    /**
     * @return BMI
     */
    @Override
    public double calculateBMI(){
        return (getWeight() / ((getHeight() * getHeight()) / 10000)) ;
    }

}
