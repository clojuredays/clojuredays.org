(ns dcd-website.sidebar)

(defn sidebar-component []
  [:aside#sidebar.sidebar.collapsed
   [:a.item.expand-icon {:onclick "switchSidebar()"} "☰"]
   [:a.item {:href "index.html" :onclick "collapseSidebar()"} "DCD26"]
   [:ul
    [:li [:a.item {:href "/#about" :onclick "collapseSidebar()"} "About"]]
    [:li [:a.item {:href "/#date" :onclick "collapseSidebar()"} "When?"]]
    [:li [:a.item {:href "/#location" :onclick "collapseSidebar()"} "Where?"]]
    [:li [:a.item {:href "/#tickets" :onclick "collapseSidebar()"} "Tickets"]]
    [:li [:a.item {:href "/#cfp" :onclick "collapseSidebar()"} "Call for proposals"]]
    #_[:li [:a.item {:href "/#agenda" :onclick "collapseSidebar()"} "Agenda"]]
    #_[:li [:a.item {:href "/#sponsors" :onclick "collapseSidebar()"} "Sponsors"]]
    [:li [:a.item {:href "/#packages" :onclick "collapseSidebar()"} "Sponsorship"]]
    #_[:a.item {:href "/#speakers" :onclick "collapseSidebar()"} "Speakers"]
    [:li [:a.item {:href "/#behave" :onclick "collapseSidebar()"} "Code of conduct"]]]
   [:br]
   [:a.item {:href "dcd2022.html" :onclick "collapseSidebar()"} "Archive: DCD2022"]
   [:a.item {:href "dcd2020.html" :onclick "collapseSidebar()"} "Archive: DCD2020"]
   [:a.item {:href "dcd2019.html" :onclick "collapseSidebar()"} "Archive: DCD2019"]
   [:a.item {:href "dcd2018.html" :onclick "collapseSidebar()"} "Archive: DCD2018"]
   [:a.item {:href "dcd2017.html" :onclick "collapseSidebar()"} "Archive: DCD2017"]
   [:a.item {:href "dcd2016.html" :onclick "collapseSidebar()"} "Archive: DCD2016"]])
