package careerhabr.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyResponseModel {
    private long id;
    private String href;
    private String title;
    private boolean isMarked;
    private boolean remoteWork;
    private SalaryQualification salaryQualification;
    private PublishedDate publishedDate;
    private Company company;
    private String employment;
    private Salary salary;
    private List<Division> divisions;
    private List<Skill> skills;
    private Media media;
    private List<Location> locations;
    private boolean favorite;
    private boolean archived;
    private boolean hidden;
    private boolean can_edit;
    @Data
    public static class SalaryQualification {
        private String title;
        private String href;
    }

    @Data
    public static class PublishedDate {
        private String date;
        private String title;
    }

    @Data
    public static class Company {
        private String alias_name;
        private String href;
        private String title;
        private boolean accredited;
        private Logo logo;
        private Rating rating;

        @Data
        public static class Logo {
            private String src;
        }

        @Data
        public static class Rating {
            private String title;
            private String value;
            private String href;
        }
    }

    @Data
    public static class Salary {
        private Integer from;
        private Integer to;
        private String currency;
        private String formatted;
    }

    @Data
    public static class Division {
        private String title;
        private String href;
    }

    @Data
    public static class Skill {
        private String title;
        private String href;
    }

    @Data
    public static class Media {
        // Add fields if needed
    }

    @Data
    public static class Location {
        private String title;
        private String href;
    }
}
