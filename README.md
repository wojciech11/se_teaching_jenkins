# Jenkins

1. Uruchom jenkins-a:

   ```
   make build_jenkins
   make run_jenkins
   ```

2. Otwórz w przeglądarce 127.0.0.1:8080, jeśli zostaniesz poproszony o hasło dla admina, wybierz:

   ```
   make show_me_password
   # lub
   cat jenkins/secrets/initialAdminPassword
   ```

3. Wybierz *Suggested plugins*.


## Related

- https://github.com/sheehan/job-dsl-gradle-example
- https://python-jenkins.readthedocs.io/en/latest/
- https://www.jenkins.io/doc/book/pipeline/jenkinsfile/
