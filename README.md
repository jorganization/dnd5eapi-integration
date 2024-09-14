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
- [x] Create a [remote repository](https://github.com/jorganization/dnd5eapi-integration?tab=readme-ov-file)
- Spells
  - [x] In spells-api create a 'hello world' endpoint.
  - [x] Run api and hit 'hello world' endpoint via Postman.
  - [ ] Create client to enable making requests to dnd5eapi.
  - [ ] Add a service layer to interface with the client.
  - [ ] Create Spells model.
  - [ ] Spells-api, new endpoint. getSpells(): returning all spells
  - [ ] (Create and import library containing spells?)
  - [ ] Spells-api, new endpoint. getSpellsByIndex()
  - [ ] Spells-api, new endpoint. getSpellsByLevel()
  - [ ] Spells-api, new endpoint. getSpellsBySchool()
  - [ ] Spells-api, new endpoint. getSpellsBySchoolAndLevel()
  - [ ] Create SpellFilter model as needed.

###
Resources used:\
[WebClient](https://www.baeldung.com/spring-5-webclient)\
[Controller](https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration)\
