import kotlin.js.Date

object Resume {
    const val name = "Volodya Gurdin"
    const val title = "Backend Software Engineer"
    const val linkedIn = "https://linkedin.com/in/volodya-gurdin-6a6892152"
    const val email = "vladi.gurdin@gmail.com"
    const val place = "Hilversum, Netherlands"

    val careerSummary =
        """Volodya Gurdin is a passionate Backend software engineer with 7+ years of experience. 
           |Through his experience, he had chance to play many roles in the team, like being a Cloud DevOps Engineer and 
           |having responsibilities of Scrum Master in teams of 10-16 people. 
           |However, his main interest was always in Server Side Development and Software Architecture.""".trimMargin()
    val finalWords = "Kotlin Advocate. Artist. Human."

    // Must be sorted by time for correct rendering
    val workExperiences = listOf(
        WorkExperience("Sabbatical", listOf(sabbatical2022)),
        WorkExperience("Csssr", listOf(prof40, arm, mpss)),
        WorkExperience("Akvelon Inc", listOf(intappExperience, intappOpenCloud)),
        WorkExperience("Freelance", listOf(freelance)),
    )

    val languages = listOf(
        LanguageRating("Kotlin (Server Side)", 90),
        LanguageRating("SQL", 80),
        LanguageRating("Java", 70),
        LanguageRating("Java Script (TS)", 60),
        LanguageRating("Scripting (Bash, Python etc)", 50),
    )

    val buzzWords = listOf(
        "TDD", "DDD", "CI/CD", "DevOps",
        "Scrum", "Kanban", "Code Review",
        "Microservices", "Cloud", "Event Driven",
        "NoSQL", "Distributed Systems", "Metrics",
    )
}

private val sabbatical2022 = Project(
    projectName = null,
    grade = null,
    description = "Took time off from commercial work to gather energy and level up my skills.",
    dateRange = Pair(date(2022, Month.March), Date()),
    achievements = listOf(
        "Spent time digging deep into the topic of Distributed Systems (replication, consistency, consensus etc)",
        "Played with various technologies",
    ),
    skills = listOf(
        JobSkill("Kafka Streams", SkillType.TOOL),
        JobSkill("Avro", SkillType.TOOL),
        JobSkill("GraphQL", SkillType.TOOL),
        JobSkill("CRDT", SkillType.TOOL),
        JobSkill("Redis", SkillType.TOOL),
        JobSkill("RabbitMq", SkillType.TOOL),
        JobSkill("Kotlin Coroutines", SkillType.TOOL),
        JobSkill("Ktor", SkillType.TOOL),
        JobSkill("Kotlin Js", SkillType.TOOL),
    )
)

private val prof40 = Project(
    grade = "Tech Lead/Senior Software Consultant",
    projectName = "P40",
    description = "Hiring and freelance platform for projects in energy industry",
    dateRange = Pair(date(2020, Month.December), date(2022, Month.February, 27)),
    achievements = listOf(
        "Completely redesigned and refactored backend from old legacy stack",
        "Achieved ~5-10x improvement in performance, feature delivery time and customer issues",
        "Radically reduced stress of QAs, Frontend and Mobile developers and generally made them a lot happier",
        "Implemented logging, monitoring and CI/CD infrastructure that detects anomalies earlier and allows to deploy fixes quickly",
    ),
    skills = listOf(
        JobSkill("Kotlin", SkillType.CODING),
        JobSkill("Spring Boot", SkillType.CODING),
        JobSkill("Exposed (SQL)", SkillType.CODING),
        JobSkill("PostgreSQL", SkillType.TOOL),
        JobSkill("Redis", SkillType.TOOL),
        JobSkill("Mattermost", SkillType.TOOL),
        JobSkill("S3", SkillType.TOOL),
        JobSkill("Teamcity", SkillType.DEVOPS),
        JobSkill("k8s", SkillType.DEVOPS),
        JobSkill("Helm", SkillType.DEVOPS),
        JobSkill("ELK", SkillType.DEVOPS),
        JobSkill("Grafana", SkillType.DEVOPS),
    )
)

private val arm = Project(
    grade = "Senior Software Consultant",
    projectName = "ARM",
    description = "Application to manage people work, collect data from mobile applications and draw analytics dashboards",
    dateRange = Pair(date(2020, Month.March), date(2020, Month.December)),
    achievements = listOf(
        "Completely refactored server side from old legacy stack, allowing project to evolve with reasonable estimations and be maintainable",
        "Implemented logging, monitoring and CI/CD infrastructure that detects anomalies earlier and allows to deploy fixes quickly",
    ),
    skills = listOf(
        JobSkill("Kotlin", SkillType.CODING),
        JobSkill("Spring Boot", SkillType.CODING),
        JobSkill("Exposed (SQL)", SkillType.CODING),
        JobSkill("PostgreSQL", SkillType.TOOL),
        JobSkill("Redis", SkillType.TOOL),
        JobSkill("S3", SkillType.TOOL),
        JobSkill("Teamcity", SkillType.DEVOPS),
        JobSkill("k8s", SkillType.DEVOPS),
        JobSkill("Helm", SkillType.DEVOPS),
        JobSkill("ELK", SkillType.DEVOPS),
        JobSkill("Grafana", SkillType.DEVOPS),
    )
)

private val mpss = Project(
    grade = "Senior Software Consultant",
    projectName = "MPSS",
    description = "Application to model possible incidents on company objects, their causes and effects with a plan how to prevent them",
    dateRange = Pair(date(2019, Month.March), date(2020, Month.November)),
    achievements = listOf(
        "Closely worked with a client and analytics to define requirements and business logic",
        "Implemented server-side logic and and maintained through several iterations of severe requirement changes",
        "Monitoring, logging, performance testing, CI/CD",
    ),
    skills = listOf(
        JobSkill("Kotlin", SkillType.CODING),
        JobSkill("Spring Boot", SkillType.CODING),
        JobSkill("Hibernate", SkillType.CODING),
        JobSkill("Exposed (SQL)", SkillType.CODING),
        JobSkill("PostgreSQL", SkillType.TOOL),
        JobSkill("Redis", SkillType.TOOL),
        JobSkill("S3", SkillType.TOOL),
        JobSkill("Keycloak", SkillType.TOOL),
        JobSkill("Kerberos & AD", SkillType.TOOL),
        JobSkill("Teamcity", SkillType.DEVOPS),
        JobSkill("k8s", SkillType.DEVOPS),
        JobSkill("Helm", SkillType.DEVOPS),
        JobSkill("ELK", SkillType.DEVOPS),
        JobSkill("Grafana", SkillType.DEVOPS),
    )
)

private val intappExperience = Project(
    grade = "Full Stack Engineer",
    projectName = "Intapp: Experience",
    description = "Experience is a multi-tenant cloud app that helps lawyer and accounting firms manage their work and clients with advanced search focused to find the best expertise for new project/client",
    dateRange = Pair(date(2016, Month.August), date(2019, Month.January, 30)),
    achievements = listOf(
        "Designed system architecture for cloud version",
        "Worked on backend for main application",
        "Implemented DevOps infrastructure and CI/CD pipeline",
        "Improved Scrum framework and practices within a team",
    ),
    skills = listOf(
        JobSkill("Java", SkillType.CODING),
        JobSkill("JS & TS", SkillType.CODING),
        JobSkill("Spring Boot", SkillType.CODING),
        JobSkill("NodeJS", SkillType.CODING),
        JobSkill("JavaRx", SkillType.CODING),
        JobSkill("AngularJs", SkillType.CODING),
        JobSkill("Sass", SkillType.CODING),
        JobSkill("Pug", SkillType.CODING),
        JobSkill("PostgresSQL", SkillType.TOOL),
        JobSkill("DynamoDb", SkillType.TOOL),
        JobSkill("Elasticsearch", SkillType.TOOL),
        JobSkill("Redis", SkillType.TOOL),
        JobSkill("RabbitMq", SkillType.TOOL),
        JobSkill("Kafka", SkillType.TOOL),
        JobSkill("Aws", SkillType.DEVOPS),
        JobSkill("DockerCloud", SkillType.DEVOPS),
        JobSkill("ELK", SkillType.DEVOPS),
    )
)
private val intappOpenCloud = Project(
    grade = "Full Stack Engineer",
    projectName = "Intapp: Open Cloud",
    description = "RnD project to migrate existing on-premise solution (.Net, SQL Server) to the cloud (Java, Aws) and build microservices platform for other company's products as basis for future cloud migration",
    dateRange = Pair(date(2015, Month.August), date(2016, Month.September, 30)),
    achievements = listOf(
        "Performed various RnD tests for different tools and frameworks according to requirements",
        "Worked on modeling data for Cassandra and migration plan from SQL Server",
        "Built Aws infrastructure for services with Netflix Oss and Spring Cloud",
        "Built platform for monitoring with ELK and Prometheus and InfluxDb",
        "Code review, meeting with managers, Jira maintaining",
    ),
    skills = listOf(
        JobSkill("Java", SkillType.CODING),
        JobSkill("Spring Cloud", SkillType.CODING),
        JobSkill("Vert.x", SkillType.CODING),
        JobSkill("Netflix Oss", SkillType.TOOL),
        JobSkill("Cassandra", SkillType.TOOL),
        JobSkill("PostgresSql", SkillType.TOOL),
        JobSkill("Aws", SkillType.DEVOPS),
        JobSkill("Consul", SkillType.DEVOPS),
        JobSkill("Terraform", SkillType.DEVOPS),
        JobSkill("Jenkins", SkillType.DEVOPS),
    )
)

private val freelance = Project(
    grade = null,
    projectName = null,
    description = "Worked on several small projects and apps, mostly for students at university. For example:",
    dateRange = Pair(date(2014, Month.April), date(2015, Month.August, 4)),
    achievements = listOf(
        "App to compare two DNA sequences and find similarities in the genome (Python)",
        "Backend for small online shop (Java, Spring, Hibernate, MySql)",
        "Tools for Maya 3D package to draw arcs of animation and to memorize poses (Python)",
    ),
    skills = listOf(
        JobSkill("C", SkillType.CODING),
        JobSkill("Python", SkillType.CODING),
        JobSkill("Java", SkillType.CODING),
        JobSkill("Hibernate", SkillType.CODING),
        JobSkill("MySQL", SkillType.TOOL),
    )
)

data class WorkExperience(
    val companyName: String,
    val projects: List<Project>,
)

data class Project(
    val grade: String?,
    val projectName: String?,
    val description: String,
    val dateRange: Pair<Date, Date>,
    val achievements: List<String>,
    val skills: List<JobSkill>,
)

data class JobSkill(
    val name: String,
    val type: SkillType
)

data class LanguageRating(
    val name: String,
    val percentage: Int
)

enum class SkillType(val cssClass: String) {
    CODING("badge-tech"),
    DEVOPS("badge-tech"),
    TOOL("badge-tech")
}

enum class Month {
    January, February, March, April, May, June, July, August, September, October, November, December
}

