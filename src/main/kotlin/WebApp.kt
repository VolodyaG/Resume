import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.*
import kotlinx.html.dom.append
import org.w3c.dom.HTMLElement
import org.w3c.dom.Node
import kotlin.js.Date
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    window.onload = { document.body?.buildResume() }
}

fun Node.buildResume() {
    append {
//        div("resume-wrapper text-center position-relative") {
        div("resume-wrapper position-relative mx-auto text-left bg-white shadow-lg") {
            personalInfo()

            div("resume-body p-4") {
                careerSummary()

                div("row") {
                    div("col-9") {
                        workExperiences()
                    }
                    div("col-3") {
                        skillsSection()
                        interestsSection()
                    }
                }
            }
        }
//        }
    }
}

private fun HtmlBlockTag.workExperiences() {
    section("resume-section experience-section mb-5") {
        h2("resume-section-title text-uppercase font-weight-bold pb-3 mb-3") { +"Work Experience" }

        div("resume-section-content") {
            div("resume-timeline position-relative") {

                Resume.workExperiences.forEach { experience ->
                    article("resume-timeline-company position-relative pb-5") {
                        h3("resume-timeline-item-header mb-2") {
                            +experience.companyName
                            if (experience.time != null) {
                                span("title-time") { +" (${experience.time})" }
                            }
                        }

                        experience.projects.forEach {
                            div("resume-timeline-project") {
                                if(experience.projects.size > 1) attributes["draw-circle"] = "true"
                                project(it)
                            }
                        }
                    }
                }

            }
        }
    }
}

private fun HtmlBlockTag.project(project: Project) {
        div("resume-timeline-item-header mb-2") {
            div("d-flex flex-column flex-md-row") {
                if (project.projectName != null) {
                    h3("resume-position-title font-weight-bold mb-1") {
                        if (project.grade != null) {
                            +"${project.grade} - ${project.projectName}"
                        } else {
                            +project.projectName
                        }
                    }
                }
            }

            div("resume-position-time") {

                +"${project.dateRange.first.toResumeString()} – ${project.dateRange.second?.toResumeString() ?: "Present"}"
                if (project.dateRange.second != null) {
                    val duration = duration(project.dateRange.first, project.dateRange.second!!)
                    small { +" (${duration.toResumeString()})" }
                }
            }
        }

        div("resume-timeline-item-desc") {
            p { +project.description }
            ul {
                for (achievement in project.achievements) {
                    li { +achievement }
                }
            }

            ul("list-inline") {
                for (skill in project.skills) {
                    li("list-inline-item") {
                        span("badge badge-primary badge-pill ${skill.type.cssClass}") { +skill.name }
                    }
                }
            }
        }
}

private fun DIV.interestsSection() {
    section("resume-section interests-section mb-5") {
        h2("resume-section-title text-uppercase font-weight-bold pb-3 mb-3") { +"""Interests""" }
        div("resume-section-content") {
            ul("list-unstyled") {
                Resume.interests.forEach {
                    li("mb-1") {
                        i(it.faIcon)
                        +" ${it.name}"
                    }
                }
            }
        }
    }
}

private fun HtmlBlockTag.skillsSection() {
    section("resume-section skills-section mb-5") {
        h2("resume-section-title text-uppercase font-weight-bold pb-3 mb-3") {
            +"""Skills"""
        }
        div("resume-skill-item") {
            h4("resume-skills-cat font-weight-bold") { +"""Languages""" }
            ul("list-unstyled") {
                Resume.languages.forEach { languageRating ->
                    li("mb-2") {
                        div("resume-skill-name") { +languageRating.name }
                        div("progress resume-progress") {
                            div("progress-bar progress-bar-striped devops-color") {
                                role = "progressbar"
                                style = "width: ${languageRating.percentage}%"
                                attributes["aria-valuenow"] = "${languageRating.percentage}"
                                attributes["aria-valuemin"] = "0"
                                attributes["aria-valuemax"] = "100"
                            }
                        }
                    }
                }
            }
        }
        div("resume-skill-item") {
            h4("resume-skills-cat font-weight-bold") { +"""Buzzwords""" }
            ul("list-inline") {
                Resume.buzzWords.forEach { buzzword ->
                    li("list-inline-item") {
                        span("badge badge-light badge-tech") { +buzzword }
                    }
                }
            }
        }
    }
}

private fun HtmlBlockTag.careerSummary() {
    section("resume-section summary-section mb-5") {
        h2("resume-section-title text-uppercase font-weight-bold pb-3 mb-3") { +"""Career Summary""" }
        div("resume-section-content") {
            p {
                Resume.careerSummary.split("<br>").forEach {
                    +it
                    br()
                }
            }
            p("mb-0") { +Resume.finalWords }
        }
    }
}

private fun TagConsumer<HTMLElement>.personalInfo() {
    header("resume-header pt-4 pt-md-0") {
        div("media flex-column flex-md-row") {
            img(classes = "mr-3 img-fluid picture mx-auto") {
                src = Resume.avatar
                alt = ""
            }
            div("media-body p-4 d-flex flex-column flex-md-row mx-auto mx-lg-0") {
                div("primary-info") {
                    h1("name mt-0 mb-1 text-white text-uppercase text-uppercase") { +Resume.name }
                    div("title mb-3") {
                        +Resume.title
                    }

                    ul("list-unstyled") {
                        li("mb-2") {
                            span {
                                i("fas fa-home fa-fw mr-2") { attributes["data-fa-transform"] = "grow-3" }
                                +Resume.place
                            }
                        }
                        li("mb-2") {
                            a(href = Resume.linkedIn, target = "_blank") {
                                i("fab fa-linkedin fa-fw mr-2") { attributes["data-fa-transform"] = "grow-3" }
                                +"LinkedIn profile"
                            }
                        }
                        li("mb-2") {
                            a {
                                i("fas fa-envelope fa-fw mr-2") { attributes["data-fa-transform"] = "grow-3" }
                                href = "mailto:${Resume.email}"
                                +Resume.email
                            }
                        }
                    }

                }
                div("secondary-info ml-md-auto mt-2") {
                    ul("resume-social list-unstyled") {
                        li("mb-3") {
                            span("fa-container text-center mr-2") { i("fab fa-github-alt fa-fw") }
                        }
                        li("mb-3") {
                            span("fa-container text-center mr-2") { i("fas fa-globe-africa") }
                        }
                        li("mb-3") {
                            span("fa-container text-center mr-2") { i("far fa-lightbulb") }
                        }
                        li("mb-3") {
                            span("fa-container text-center mr-2") { i("fas fa-heart") }
                        }
                    }
                }
            }
        }
    }
}

fun date(year: Int, month: Month, day: Int = 1) = Date(year, month.ordinal, day)
fun duration(from: Date, to: Date) = (to.getTime().toLong() - from.getTime().toLong()).milliseconds

fun Duration.toResumeString(): String {
    val years = this.inWholeDays / 365
    val months = (this.inWholeDays - (years * 365)) / 30 + 1
    return "$years years $months months"
}

fun Date.toResumeString(): String {
    val month = Month.values()[this.getMonth()]
    return "$month ${getFullYear()}"
}