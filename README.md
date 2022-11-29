# ClojureDays conference public website

Welcome to the ad-hoc, home-grown, half-assed static site generator for the https://clojuredays.org website!

This repository hosts the sources as well as the public site itself on top of GitHub pages.

## Generate the css and html (and possibly at some time js)

### Prerequisites

- [sass](https://sass-lang.com/install) (optional)

### Compile the stylesheet

Styles are written in SCSS, so you need to translate them into vanilla CSS. You have two options:

- the recommended way is to install `sass` in some way then:

```shell
sass sass/css/main.scss public/css/main.css
```

### Generate the static pages

```shell
clojure -X:generate-html
```

### Serve the static site locally

Assuming you have `python3` installed on your system:

```shell
$(cd public && python3 -m http.server)
```

or run
```shell
./serve.sh
```

The website is then accessible at http://localhost:8000

## Build script
To generate both the CSS and HTML pages, run:
```shell
./build.sh
```

## Deploying changes

Push to `master` will build and deploy the site using Github
Actions. See `.github/workflows/build-and-deploy.yaml`
