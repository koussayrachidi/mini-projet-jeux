package com.koussay.jeux.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entreprise {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idEnt;
   private String nomEnt;
   private int nombreEmployes;
   
   
   @OneToMany(mappedBy = "entreprise")
   @JsonIgnore
   private List<Jeu> jeux;

   

}
