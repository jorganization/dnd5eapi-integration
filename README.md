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
- Create a [remote repository](https://github.com/jorganization/dnd5eapi-integration?tab=readme-ov-file)
#### Spells
- Create a spells-interface-api(spells-api) as a SpringBoot app.
- In spells-api create a 'hello world' endpoint.
- Run api and hit 'hello world' endpoint via Postman.
- Spells-api, new endpoint. getSpells(): returning all spells
- Create Spells model.
- (Create and import library containing spells?)
- Spells-api, new endpoint. getSpellsByIndex()
- Spells-api, new endpoint. getSpellsByLevel()
- Spells-api, new endpoint. getSpellsBySchool()
- Spells-api, new endpoint. getSpellsBySchoolAndLevel()
- Create SpellFilter model as needed.

