- The name Survivor seems to be a misfit for one situation. Person might
  be a better name. At any time, a person may become a zombie,
  and will still be a person. But zombies shouldn't be considered survivors.

- Resource and Item are two names for the same concept.
  I decided to use Item since the word resource might
  get confused with REST resource.
  
- Infected and contamined seem to be the same concept.
  However, some points of the specification suggest
  that they are not. For instance: "A survivor is marked as
  infected when at least three other survivors report their
  contamination". Or maybe the difference lies on the words
  flag and mark: flagging means merely indicating, while
  marking means that the informating will become a fact.
  
- The zombie property is currently on the Survivor class.
  It could be moved away to a separate class, since zombie
  is not an inherent person datum (like name is).
  
- Survivors are physically marked as zombies as soon as three other
  survivors flag them as contaminated. This is unnecessary,
  since we could determine who is a zombie by counting the flags
  every time. But marking should make the operation faster.
