(ns novel-browser.view.views
  (:require [re-frame.core :as re-frame]
            [novel-browser.sub.core :as sub]
            [novel-browser.view.top :as top])
  )

(defn- panels
  [panel-name]
  (case panel-name
    :top [top/panel]))

(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::sub/active-panel])]
    [show-panel @active-panel]))
