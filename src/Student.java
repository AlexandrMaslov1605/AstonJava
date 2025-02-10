public class Student implements Comparable<Student> {
    private String groupNumber;
    private Double gpa;
    private Integer recordNumber;

    private Student(StudentBuilder studentBuilder){
        groupNumber = studentBuilder.groupNumber;
        gpa = studentBuilder.gpa;
        recordNumber = studentBuilder.recordNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public Double getGpa() {
        return gpa;
    }

    public Integer getRecordNumber() {
        return recordNumber;
    }

    @Override
    public int compareTo(Student o) {
        return this.recordNumber.compareTo(o.recordNumber);
    }
    public static class StudentBuilder{
        private String groupNumber;
        private Double gpa;
        private Integer recordNumber;

        public StudentBuilder setGroupNumber(String groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public StudentBuilder setGpa(Double gpa) {
            this.gpa = gpa;
            return this;
        }

        public StudentBuilder setRecordNumber(Integer recordNumber) {
            this.recordNumber = recordNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
