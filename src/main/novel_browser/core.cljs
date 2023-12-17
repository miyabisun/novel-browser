(ns novel-browser.core
  (:require [accountant.core :as accountant]
            [bidi.bidi :as bidi]
            [reagent.dom :as rd]
            [novel-browser.dispatch :refer [dispatch]]
            [novel-browser.routes :as routes]
            [novel-browser.view.views :as views]))

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (rd/render [views/main-panel]
             (.getElementById js/document "app")))

(defn setup-routes []
  (accountant/configure-navigation!
    {:nav-handler (fn [path]
                    (let [match (bidi/match-route routes/client path)]
                      (dispatch (:handler match) (:route-params match))))
     :path-exists? (fn [path]
                     (some? (bidi/match-route routes/client path)))})
  (accountant/dispatch-current!))

(defn ^:export init []
  (dispatch :init)
  (setup-routes)
  (start))
