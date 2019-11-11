package application.utils.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api(){
    	return new Docket(DocumentationType.SWAGGER_2)  
    	          .select()                                  
    	          .apis(RequestHandlerSelectors.basePackage("application.controller"))
    	          .paths(PathSelectors.any())                          
    	          .build()
    	          .tags(
    	        		  new Tag("Equipe", "Ensemble des fonctions disponibles pour la gestion d'une equipe"),
    	        		  new Tag("Club", "Ensemble des fonctions disponibles pour la gestion d'un club"),
    	        		  new Tag("Joueur", "Ensemble des fonctions disponibles pour la gestion d'un joueur"),
    	        		  new Tag("StatistiqueEquipe", "Ensemble des fonctions disponibles pour la gestion des statistiques d'une équipe"),
    	        		  new Tag("StatistiqueJoueur", "Ensemble des fonctions disponibles pour la gestion des statistiques d'un joueur"),
    	        		  new Tag("Presence", "Ensemble des fonctions disponibles pour la gestion des présences d'un joueur à un event"),
    	        		  new Tag("Event", "Ensemble des fonctions disponibles pour la gestion d'un event"),
    	        		  new Tag("Match", "Ensemble des fonctions disponibles pour la gestion des matchs"),
    	        		  new Tag("Lieu", "Ensemble des fonctions disponibles pour la gestion des lieux de rendez-vous"),
    	        		  new Tag("Adresse", "Ensemble des fonctions disponibles pour la gestion des adresses"),
    	        		  new Tag("Ville", "Ensemble des fonctions disponibles pour la gestion des villes"),
    	        		  new Tag("Configuration", "Ensemble des fonctions disponibles pour la configuration (sports disponibles, catégories, ...)")
    	        	); 
    }
}
