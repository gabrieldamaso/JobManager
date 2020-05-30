# JobManager
this API is a Job Organizer for processing job queues performed within 8 hours

stack:
* Java
* Spring Boot 2.3.0.RELEASE
* lombok

path for job registration: Post localhost:8080/job/

request body exemple:
[
    {
        "id": 1,
        "descricao": "descricao",
        "dataMaximaDeConclusao": "2020-05-27T22:28:18.927642",
        "tempoEstimado": 4
    },
    {
        "id": 2,
        "descricao": "descricao2",
        "dataMaximaDeConclusao": "2020-05-29T19:28:18.927725",
        "tempoEstimado": 9
    },
    {
        "id": 3,
        "dataMaximaDeConclusao": "2020-05-28T19:28:18.927725",
        "tempoEstimado": 2
    }
]






