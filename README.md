# containers
Este proyecto permite indica los contenedores que se deben seleccionar para su transporte, obteniendo el mayor KPI(Key performance indicator)

## Instrucciones para le ejecución del api

**Url Api**  : http://containerselector-env.eba-ksus33tp.us-east-1.elasticbeanstalk.com
+ **Operaciones**
    + **POST → /containers/**
Al consumir esta operaciones se obtendra los contenedores a transportar.
**Ejemplo Body:**
`{"budget":1610,"containers":[{"name":"C1","containerPrice":7630,"transportCost":327},{"name":"C2","containerPrice":9495,"transportCost":422}]}`
**Posibles Respuestas:**
 -  **Http 200**: Para una selección de contenedores valida
 - **Http 400**: Parametros incorrectos

  + **GET → /stats/**
    Al consumir esta operación podras obtener las estadisticas de cuanto es valor de los conetenedores enviados, el valor de los contenedores que no se enviarion y el costo total utilizado.
