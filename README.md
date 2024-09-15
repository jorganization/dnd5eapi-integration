# dnd5eapi-integration
## what is?
A monorepo for fetching and displaying data pulled from [_dnd5eapi_](https://5e-bits.github.io/docs/api).
## architecture 
TBD... Expect an image.
## stack
- Java 21
- Spring-Boot
- Maven
- Angular
- TypeScript
- (Goal/TBD/Tentative) Copilot, Helm Charts, Kubernetes, Podman, MongoDB, more...

## get it running
TBD... Will supply environment variables as they become requires.
## resources
TBD... Will sight external resources/documentation I used to create this application.
## licensing
MIT - 2024

---

### ToDo...
- [ ] Create and import library containing models.
- [ ] Add postman collection for api.
- Skills
  - [ ] Create Equipment model
  - [ ] New endpoint: getEquipment()
- Spells
  - [x] Create Spells model.
  - [x] Spells-api, new endpoint. getSpells(): returning all spells
  - [x] Spells-api, new endpoint. getSpellsByIndex()
  - [x] Spells-api, new endpoint. getSpellsByLevel()
  - [x] Spells-api, new endpoint. getSpellsBySchool()
  - [x] Spells-api, new endpoint. getSpellsBySchoolAndLevel()
  - [x] Fetch spell's details
  - [x] Map spell's details and spell's reference into a custom model (SpellDetail)
  - [x] Refactor endpoints to return List<SpellDetails>
  - [x] Fix all mapping issues for each Spell
  - [x] Clean up duplicated code in SpellsService
- Foundation
  - [x] Create a [remote repository](https://github.com/jorganization/dnd5eapi-integration?tab=readme-ov-file)
  - [x] In spells-api create a 'hello world' endpoint.
  - [x] Run api and hit 'hello world' endpoint via Postman.
  - [x] Create client to enable making requests to dnd5eapi.
  - [x] Add a service layer to interface with the client.


###
Resources used:\
[WebClient](https://www.baeldung.com/spring-5-webclient)\
[Controller](https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration)\
[RestTemplate](https://www.baeldung.com/rest-template)\
 