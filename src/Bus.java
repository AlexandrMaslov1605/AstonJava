public class Bus {
    private String number;
    private String model;
    private Integer mileage;

    private Bus (BusBuilder busBuilder){
        number = busBuilder.number;
        model = busBuilder.model;
        mileage = busBuilder.mileage;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public Integer getMileage() {
        return mileage;
    }

    public static class BusBuilder{
        private String number;
        private String model;
        private Integer mileage;

        public BusBuilder setNumber(String number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(Integer mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }
}
