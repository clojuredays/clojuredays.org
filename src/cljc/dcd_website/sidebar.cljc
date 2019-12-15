(ns dcd-website.sidebar)

(defn sidebar-component []
  [:aside#sidebar.sidebar.collapsed
   [:a.item.expand-icon {:onclick "switchSidebar()"} "☰"]
   [:a.item {:href "/#about" :onclick "collapseSidebar()"} "About"]
   [:a.item {:href "/#cfp" :onclick "collapseSidebar()"} "Call for papers"]
   [:a.item {:href "/#date" :onclick "collapseSidebar()"} "When?"]
   #_[:a.item {:href "/#agenda" :onclick "collapseSidebar()"} "Agenda"]
   #_[:a.item {:href "/#sponsors" :onclick "collapseSidebar()"} "Sponsors"]
   #_[:a.item {:href "/#speakers" :onclick "collapseSidebar()"} "Speakers"]
   [:a.item {:href "/#behave" :onclick "collapseSidebar()"} "Code of conduct"]
   [:a.item {:href "/#location" :onclick "collapseSidebar()"} "Where?"]
   [:a.item {:href "dcd2019" :onclick "collapseSidebar()"} "Archive: DCD2019"]
   [:a.item {:href "dcd2018" :onclick "collapseSidebar()"} "Archive: DCD2018"]
   [:a.item {:href "dcd2017" :onclick "collapseSidebar()"} "Archive: DCD2017"]
   [:a.item {:href "dcd2016" :onclick "collapseSidebar()"} "Archive: DCD2016"]])
