def dia = new Date()
pipeline{
  agent any
  stages{
    stage("fecha"){
      steps{
        script{
           println dia.format("yyyy/MM/dd")
        }
      }
    }
    stage("informatico"){
      steps{
        script{
          if(dia.getDay() == "Thursday"){
            println "¿Qué le menciona una IP a otra? — ¿Qué tramas?."
          }
        }
      }
    }
    stage("humor negro"){
      steps{
        script{
          if(dia.getDay() == "Friday"){
            println "Podríamos tener otro hijo? Sí, a mí tampoco me gusta el que tenemos."
          }
        }
      }
    }
    stage("futbol"){
      steps{
        script{
          if(dia.getDay() == "Monday"){
            println "¿Cómo se llama el peor jugador japonés? Nikito Nitoko."
          }
        }
      }
    }
    stage("politica"){
      steps{
        script{
          if(dia.getDay() == "Tuesday"){
            println "Le he pedido a mi marido que me llevase a ver LOS MISERABLES y hemos estado una hora sentados frente a la puerta del Congreso de los Diputados."
          }
        }
      }
    }
    stage("medicos"){
      steps{
        script{
          if(dia.getDay() == "Wednesday"){
            println "Tengo tres llamadas perdidas de mi oftalmólogo... El de ver me llama."
          }
        }
      }
    }
  }
}
