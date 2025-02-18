import './cookieconsent.umd.js'

/**
 * All config. options available here:
 * https://cookieconsent.orestbida.com/reference/configuration-reference.html
 */
CookieConsent.run({
    categories: {
        necessary: {
            enabled: true,  // this category is enabled by default
            readOnly: true  // this category cannot be disabled
        },
        analytics: {}
    },

    language: {
        default: 'en',
        translations: {
            en: {
                consentModal: {
                    title: 'How about a cookie?',
                    description: 'The Clojure Days website uses cookies to improve our user experience, but you can choose to avoid storing them',
                    acceptAllBtn: 'Accept all',
                    acceptNecessaryBtn: 'Reject all',
                    showPreferencesBtn: 'Manage Individual preferences'
                },
                preferencesModal: {
                    title: 'Manage cookie preferences',
                    acceptAllBtn: 'Accept all',
                    acceptNecessaryBtn: 'Reject all',
                    savePreferencesBtn: 'Accept current selection',
                    closeIconLabel: 'Close',
                    sections: [
                        {
                            title: 'Somebody said ... cookies?',
                            description: 'Yummy!! Well, not always. As you probably know, we (and whomever provides us with analytics services) can track your journey over this website.<br/>We obviously won\'t ever do anything harmful nor malicious with your navigation data, but you still have to trust us and our analytics of choice, which we don\'t want to force on you.<br/>Feel free to thrash our cookies, we won\'t take it personal!'
                        },
                        {
                            title: 'Strictly Necessary cookies',
                            description: 'These cookies are essential for the proper functioning of the website and cannot be disabled.',

                            //this field will generate a toggle linked to the 'necessary' category
                            linkedCategory: 'necessary'
                        },
                        {
                            title: 'Performance and Analytics',
                            description: 'These cookies collect information about how you use our website. All of the data is anonymized and cannot be used to identify you.',
                            linkedCategory: 'analytics'
                        },
                        {
                            title: 'More information',
                            description: 'For any queries in relation to our policy on cookies and your choices, please <a href="mailto:events@clojuredays.org">contact us</a>'
                        }
                    ]
                }
            }
        }
    }
});
