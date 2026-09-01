package team.anonyms.athletelink.notificationservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @param to an email to send, usually any user's email.
 * @param subject a title of an email.
 * @param body a text of an email.
 */
public record EmailNotificationRequest(
        @Email
        @NotBlank
        String to,

        @NotBlank
        String subject,

        @NotBlank
        String body
) {
}
