public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        String concatenatedFeedback = sent1 + " " + sent2 + " " + sent3 + " " + sent4 + " " + sent5;
        return concatenatedFeedback;
    }

    private StringBuilder feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5) {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ").append(sent2).append(" ").append(sent3).append(" ").append(sent4).append(" ").append(sent5);
        return sb;
    }

    private boolean checkFeedbackLength(String completeFeedback) {
        this.longFeedback = completeFeedback.length() > 500;
        return this.longFeedback;
    }

    private void createReviewID(String firstName, String lastName, String completeFeedback) {
        String namePart = (firstName + lastName).substring(2, 6).toUpperCase();
        String feedbackPart = completeFeedback.substring(10, 15).toLowerCase();
        String lengthPart = completeFeedback.length() + "_";
        String timePart = String.valueOf(System.currentTimeMillis());
        String id = namePart + feedbackPart + lengthPart + timePart;
        this.reviewID = id.replace(" ", "");
    }

    public void analyseFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        if (isConcatenation) {
            this.completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            StringBuilder sb = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5);
            this.completeFeedback = sb.toString();
        }
        checkFeedbackLength(this.completeFeedback);
        createReviewID(this.firstName, this.lastName, this.completeFeedback);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", completeFeedback='" + completeFeedback + '\'' +
                ", reviewID='" + reviewID + '\'' +
                ", longFeedback=" + longFeedback +
                '}';
    }

    public static void main(String[] args) {
        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride.";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family.";

        Feedback feedback = new Feedback("John", "Doe", "john.doe@example.com");
        feedback.analyseFeedback(false, sent1, sent2, sent3, sent4, sent5);
        System.out.println(feedback);
    }
}
