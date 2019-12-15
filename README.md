# Generating the css and html (and possibly at some time js)

* `lein sass && lein run` Because at the moment Netlify has no  support for clj tools yet, leingen is used.

## Prerequisites

leiningen

# Deploying changes

Configure Netlify to execute `lein sass && lein run` before deploy, also configure it to minify the css/js.