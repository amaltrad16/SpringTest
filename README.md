# Entity Configuration

## Entity Setup
1. `@Entity`
2. attributs privés + getters & setters (lombok)
3. clé primaire (`@Id`)

## trucs :

pour les champs de type date => `@Temporal`
- `@Temporal(TemporalType.DATE)` yyyy / MM / dd
- `@Temporal(TemporalType.TIMESTAMP)` yyyy / MM / dd hh ss ...

pour les enums `@Enumerated`
- `@Enumerated(EnumType.STRING)` => chaine de caractère dans la base.
- `@Enumerated(EnumType.ORDINAL)` => 1,2,3 ... dans la base.

## Checker ma conception :
1. clic sur loupe.
2. ecrire persistence
3. clic droit => entity to relationship diagram.

# Repository:
1. `@Repository`
2. Interface
3. extends JpaRepository < WrapperClass mte3 l ID, Nom de l'entité>

For example id = int ==> Integer (wrapper class de int)
For example id = double ==> Double (wrapper class de int)

# Service :
1. `@Service`
2. tu injectes les repositories à utiliser via `@Autowired` par exmple.

# Controller :
1. `@RestController`
2. Injection des services à utiliser
3. Lien swagger : http://localhost:8081/swagger-ui/index.html


# CRON :
1. `@EnableScheduling` dans la classe MAIN.
2. Créer une méthode non paramétrée => method () dans un Service qq.
3. Ajouter `@Scheduled` sur la méthode non paramétrée
   => fixedRate : starts every 60 seconds for example.
   => fixedDelay : starts after 60 seconds from the last iteration termination. (wait for n-1 + delay to start)