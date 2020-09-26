# Deploy to heroku

Create a new project on heroku

### Setup Environment Variables
```
KTOR_CORS_ALLOWED_HOSTS=<insert comma separated list of hosts> default: *
```

### Add Buildpacks
Add these buildpacks to your project:
* https://github.com/heroku/heroku-buildpack-multi-procfile
* heroku/gradle

### Configure Procfile
You have to point to correct Procfile in repo which is `server/Procfile`

```bash
heroku config:set PROCFILE=server/Procfile
```

### Configure Build Task
You have to change default task in order to ask heroku to run server project:

```bash
heroku config:set GRADLE_TASK="server:stage"
```

