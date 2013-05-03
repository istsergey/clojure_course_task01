(ns task01.core
  (:require [pl.danieljanus.tagsoup :refer :all])
  (:gen-class))

(defn isClassL [v]
  (and (map? v) (= (:class v) "l"))
)

(defn getHref [v]
  (:href v)
)

(defn get-links []
  ; необходимо достать href из элементов вида <a class="l"
  (let [data (parse "clojure_google.html")]
    ; 1) разворачиваем все элементы в одну последовательность - "(flatten data)"
    ; 2) Выбираем все maps содержащие класс "l"- "filter isClassL...."
    ; 3) Получаем элементы href
    (map getHref (filter isClassL (flatten data)))
  ))
  
(defn -main []
  (println (str "Found " (count (get-links)) 
             " links!")))
































