package com.digital.epharmacy.entity.Order;


public class OrderHistory {
    private String userId;
    private int totalNumberOfOrders;
    private double totalOrderValue;

    //default contructor - Ayabulela Mahlathini
    private OrderHistory(){}

    public OrderHistory(Builder builder){
        this.userId = builder.userId;
        this.totalNumberOfOrders = builder.totalNumberOfOrders;
        this.totalOrderValue = builder.totalOrderValue;
    }

    public String getUserId() {
        return userId;
    }

    public int getTotalNumberOfOrders() {
        return totalNumberOfOrders;
    }

    public double getTotalOrderValue() {
        return totalOrderValue;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "userId=" + userId +
                ", totalNumberOfOrders=" + totalNumberOfOrders +
                ", totalOrderValue=" + totalOrderValue +
                '}';
    }

    public static class Builder{
        private String userId;
        private int totalNumberOfOrders;
        private double totalOrderValue;

        public Builder setUserId(String userId){
            this.userId = userId;
            return this;
        }

        public Builder setTotalNumberOfOrders(int totalNumberOfOrders){
            this.totalNumberOfOrders= totalNumberOfOrders;
            return this;
        }

        public Builder setTotalOrderValue(double totalOrderValue){
            this.totalOrderValue = totalOrderValue;
            return this;
        }

        public Builder copy(OrderHistory orderHistory){
            this.userId = orderHistory.userId;
            this.totalNumberOfOrders = orderHistory.totalNumberOfOrders;
            this.totalOrderValue= orderHistory.totalOrderValue;
            return this;
        }

        public OrderHistory build(){
            return  new OrderHistory(this);
        }
    }
}
