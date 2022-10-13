package Project3;

public class knapsackItem {
    private int weight;
    private int profit;
    
    public knapsackItem(){}
    
    public knapsackItem(int w, int p){
        this.weight = w;
        this.profit = p;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getProfit(){
        return this.profit;
    }

    public void setWeight(int w){
        this.weight = w;
    }

    public void setProfit(int p){
        this.profit = p;
    }
}
