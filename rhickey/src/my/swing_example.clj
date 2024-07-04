(ns my.swing-example)

;; Create a celsius -> Farenheit converter swing program.
;; Opens a small applet.
;; https://www.youtube.com/watch?v=hb3rurFxrZ8
;; ~16:00 minutes

(import '(javax.swing JFrame JLabel JTextField JButton))
(import '(java.awt.event ActionListener))
(import '(java.awt GridLayout))

(defn celsius
  ""
  []
  (let [frame (JFrame. "Celsius Converter")
        temp-text (JTextField.)
        celsius-label (JLabel. "Celsius")
        convert-button (JButton. "Convert")
        fahrenheit-label (JLabel. "Farenheit")]

    (.addActionListener convert-button
                        (proxy [ActionListener] []
                          (actionPerformed [evt]
                            (let [c (. Double parseDouble (.getText temp-text))]
                              (.setText fahrenheit-label
                                        (str (+ 32 (* 1.8 c)) " Fahreneit"))))))
    (doto frame
      (.setLayout (GridLayout. 2 2 3 3))
      (.add temp-text) (.add celsius-label)
      (.add convert-button) (.add fahrenheit-label)
      (.setSize 300 80) (.setVisible true))))

(celsius)
