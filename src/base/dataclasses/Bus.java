package base.dataclasses;

public class Bus implements Comparable<Bus>{
    private String number;
    private String model;
    private Integer mileage;

    private Bus(BusBuilder busBuilder) {
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

    @Override
    public int compareTo(Bus o) {
        return this.mileage.compareTo(o.mileage);
    }

    public static class BusBuilder {
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

    @Override
    public String toString() {
        String str = String.format(", Модель: %-8s", model);
        String str1 = String.format(", Пробег: %-6d", mileage);
        return "[" +
                "Номер автобуса: " + number +
                str +
                str1 +
                ']';
    }
}
