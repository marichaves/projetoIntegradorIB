# Projeto Integrador IB - Understanding the Concepts of Relational Database.
Developers of this project: Igor Vinicius Ferreira Dias, Lucas Freitas de Queiroz, Lucas Wander Barbosa Fonseca, Mariana Nolasco Chaves, Talia Vieira Gonçalves.

In this project proposed by the Analysis and Systems Development course at the Catholic University of Goiás, the objective is to integrate a database with a Java application. To achieve the goal of the project, we created an application capable of updating status, adding, and removing data from a database acquired from the Brazilian Unified Health System (Sistema Único de Saúde - SUS). We used the MySQL server as a solution for managing vaccination data. We provide an overview of the problem, present the conceptual, logical, and physical modeling of the database, as well as the data used from the vaccinated population.

Right after this, we will discuss the conceptual modeling of the database. We have identified the main entities: "Patient" and "Vaccine," along with their relationships. The "Patient" entity holds pertinent information such as the patient's name, age, gender, vaccines, doses, vaccination date, and the person's address. When creating the conceptual model, we assign the document_id as the primary key to ensure it remains an unchangeable record within our database.

Here's the visual representation of the conceptual model:
![Image Alt Text](https://github.com/marichaves/projetoIntegradorIB/raw/main/assets/Imagem1.png)

The cardinality between the "Patients" and "Vaccine" entities has been established, where the relationship between the two is "take," which can imply that: Patients have taken such vaccines. Using cardinality, we apply a one-to-many relationship to both patients and vaccines.

Moving forward, we will observe how the logical modeling transforms the conceptual model into a relational database schema. We employed SQL language to create the "Patient" and "Vaccine" tables, defining the necessary primary and foreign keys to ensure data integrity.

Here is the visual representation of the logical model of the applications implemented within the database:
