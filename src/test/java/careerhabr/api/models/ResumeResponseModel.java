package careerhabr.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResumeResponseModel {
    private String id;
    private String title;
    private String href;
    private String conversationHref;
    private Avatar avatar;
    private LastVisited lastVisited;
    private String specialization;
    private Qualification qualification;
    private Salary salary;
    private Availability availability;
    private Location location;
    private boolean remoteWork;
    private boolean relocation;
    private Skill[] skills;
    private Age age;
    private Experience experience;
    private LastJob lastJob;
    private Education education;
    private AdditionalEducation[] additionalEducation;
    private Community[] communities;
    private Coworker[] coworkers;
    private Specialization[] specializations;
    private int gender;
    private boolean isExpert;
    private int moreUniversityCount;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Avatar {
        private String src;
        private String src2x;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LastVisited {
        private String title;
        private String date;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Qualification {
        private String title;
        private int value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Salary {
        private String title;
        private int value;
        private String currency;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Availability {
        private String title;
        private String value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        private String title;
        private String name;
        private String href;
        private int value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Skill {
        private String title;
        private String href;
        private int value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Age {
        private String title;
        private int value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Experience {
        private String title;
        private int value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LastJob {
        private String position;
        private Company company;
        private Duration duration;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Company {
            private String title;
            private String href;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Duration {
            private String title;
            private int value;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Education {
        private University university;
        private String faculty;
        private Duration duration;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class University {
            private String title;
            private String href;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Duration {
            private String title;
            private int value;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AdditionalEducation {
        private String title;
        private String href;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Community {
        // Add fields if needed
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coworker {
        // Add fields if needed
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Specialization {
        private String title;
    }
}

