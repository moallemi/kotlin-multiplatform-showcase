# Deploy to heroku

Create a new project on heroku

### Setup Environment Variables
```
KMP_SHOWCASE_API_BASE_URL_DEFAULT=<insert>
KMP_SHOWCASE_DEPLOY_PROJECT=web
```

### Add Buildpacks
Add these buildpacks to your project:
* https://github.com/heroku/heroku-buildpack-multi-procfile
* heroku/gradle

### Configure Procfile
You have to point to correct Procfile in repo which is `deploy/Procfile`

```bash
heroku config:set PROCFILE=deploy/Procfile
```

### Configure Build Task
You have to change default task in order to ask heroku to build web project:

```bash
heroku config:set GRADLE_TASK="deploy:stage"
```


