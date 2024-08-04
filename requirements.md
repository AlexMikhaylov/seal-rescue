# Seal Rescue Project Requirements

## Database of Seal Rehabilitation and Rescue Centers:
- Comprehensive list of known rescue centers worldwide.
- Detailed information for each center: location, contact details, website, seal species, social media links, description, status (active or inactive).
- Use this Seal Rescue Centers Table: [Seal Rescue Data](https://docs.google.com/spreadsheets/d/1KJbuNZ3RghM8SwCH7SURQwav468E0BKiNhXqxxqjEvE/edit?gid=0#gid=0)
- Design an ER diagram
- Implement Hibernate
    - [Flyway Database Migrations](https://www.baeldung.com/database-migrations-with-flyway)

## Search and Filter Functionality:
- Search by region, name, or seals.
- Filters for specific criteria such as name, country, seals type.

## Embedded Interactive Maps:
- Use of interactive maps to display locations of rescue centers and their address.
    - [Mapbox API Documentation](https://docs.mapbox.com/api/overview/)
    - [Mapbox Java Library](https://github.com/mapbox/mapbox-java)

## Admin Dashboard:
- Authentication and authorization using JWT:
    - [Spring Security JWT](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)
- Interface for administrators to add, update, and manage rescue center information and news content.
- Role-based access control to allow representatives of rescue centers to update their information.

## Multilingual Support:
- Support for multiple languages on the website.
- Language switcher for users to select their preferred language: English as Default.
- Translation of all content, including static text and dynamic data.
    - Use ngx-translate: [ngx-translate/core](https://github.com/ngx-translate/core) (en.json for default English)

## News Section and Newsletter:
- Section for news and updates related to seal rescues and rehabilitation.
- Newsletter subscription to notify users about new rescue centers or important updates.
- Fetch new seal rescue centers and publish them as news feed via an API.

## Suggestion Form for Missing Rescue Centers:
- A contact form where users can suggest missing rescue centers.
- Collect information like the name of the rescue center, location, contact details, and additional notes.
- Send the suggestion to the administrators for review and possible inclusion.

## Implementation Notes:
- **Backend:** Kotlin Spring Boot as API server
- **Database:** PostgreSQL
- **Frontend:** Angular project

## GitHub Repository:
- [GitHub Repository: seal-rescue](https://github.com/AlexMikhaylov/seal-rescue)
    - backend → gradle Spring Boot
    - frontend → Angular

## Project Architecture:
- Start with a monolithic architecture and refactor to microservices as the project grows. Starting with a monolithic application might be more practical for the initial development and learning phase.

## Domain:
- Use `sealrescue.info` as the primary domain for this project.

## Responsiveness:
- Use Bootstrap: [ng-bootstrap](https://ng-bootstrap.github.io/#/home)
- or Material-UI: [Material-UI](https://material.angular.io/)

## Next Steps:
1. Create GitHub repository and directories ✅
    - [GitHub Repository: seal-rescue](https://github.com/AlexMikhaylov/seal-rescue)
2. Check the ideas provided above ✅
3. Design the first ER diagram draft ✅
4. Update the ER diagram & check the scalability ✅
5. Create a CSV file for the database from the Excel table ✅
6. Create a seeding script in the backend project (from csv): seal, station, countries, roles etc tables (for all tables without users and subscriptions) using Flyway ✅
7. Implement two controllers for the user registration and user login endpoints (in progress)
8. Initialize a setup of Angular https://angular.dev/installation/ in the frontend directory ✅

