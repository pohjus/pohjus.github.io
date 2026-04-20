# AI-avusteinen ohjelmistokehitys

## Yleiskatsaus

Tämä neljän päivän (2 + 2) koulutus käsittelee siirtymää perinteisestä ohjelmistokehityksestä AI-natiiviin kehitysmalliin.
Koulutus jakautuu kahteen moduuliin:

- **Moduuli 1: AI-avusteinen ohjelmistokehitys käytännössä** (2 pv): tekoälyn käyttö osana päivittäistä kehitystyötä.
- **Moduuli 2: AI sovelluksissa, agentteina ja tuotannossa** (2 pv): tekoälyn integrointi osaksi sovelluksia, agenttien rakentaminen ja sovellusten vieminen tuotantoon.

Koulutus on käytännönläheinen.

## Kohderyhmä

Koulutus on suunnattu ohjelmistokehittäjille, jotka haluavat integroida tekoälyn osaksi päivittäistä kehitystyötään.

## Esitiedot

- Osaamista yhdestä ohjelmointikielestä, esim Python, Java, JavaScript tms.
- Versionhallinnan ja komentoriviympäristön hallintaa

**Aiempaa kokemusta tekoälytyökaluista ei vaadita.**

## Oppimistavoitteet

Koulutuksen päätyttyä osallistuja:

- Osaa hyödyntää tekoälyä käytännön ohjelmistokehityksessä päivittäisenä työkaluna
- Ymmärtää eri AI-koodaustyökalujen vahvuudet ja osaa valita tilanteeseen sopivan
- Osaa tuottaa, testata ja katselmoida koodia AI:n avulla
- Ymmärtää, miten AI integroidaan osaksi sovelluksia eri integraatiostrategioilla
- Tuntee agentti- ja MCP-arkkitehtuurin periaatteet ja osaa soveltaa niitä
- Osaa viedä AI-avusteisen prototyypin hallitusti kohti tuotantoa

## Tarvittavat työkalut ja käyttöoikeudet

Koulutus järjestetään etäkoulutuksena. Osallistujalla tulee olla käyttöoikeus seuraaviin työkaluihin ennen koulutuksen alkua.

### Claude

Vaikka koulutuksessa käsitellään useita AI-työkaluja (Codex, Claude, Gemini jne.), harjoitukset rakentuvat Clauden varaan. Osallistuja tarvitsee koulutuksessa Clauden käyttöoikeuden.

**Vaihtoehto A: Yrityksen API-avaimet (suositeltu)**

Järjestävä yritys luo tilin osoitteessa console.anthropic.com, lataa sille krediittejä (pay-as-you-go) ja luo API-avaimet osallistujille. Osallistujat konfiguroivat Claude Coden käyttämään annettua API-avainta oman kirjautumisen sijaan. Käyttö laskutetaan tokenipohjaisesti yrityksen krediittisaldosta, eikä käyttäjäkohtaisia tuntirajoja ole, joten työskentely jatkuu yhtäjaksoisena niin kauan kuin krediittejä riittää.

**Vaihtoehto B: Henkilökohtainen tilaus**

Jokainen osallistuja käyttää omaa **Claude Pro- tai Team-tilaustaan** (Team suositeltavampi suurempien käyttörajojen vuoksi). Huomaa, että Claude Prossa on käyttörajat, jotka nollautuvat muutaman tunnin välein, ja intensiivinen käytännön työ voi kuluttaa rajan loppuun kesken istunnon.

_Yrityksen API-avaimilla varmistetaan, että harjoitteet etenevät keskeytyksettä koko koulutuspäivien ajan, ilman riskiä kiintiörajojen aiheuttamista katkoksista._

### GitHub

Osallistujalla tulee olla GitHub-tili – henkilökohtainen tai organisaation tarjoama. Tiliä käytetään harjoitusten versionhallintaan ja CI/CD-harjoituksissa.

### Slack

Osa koulutuksen kommunikoinnista tapahtuu Slackin kautta. Osallistujalla tulee olla pääsy koulutuksen Slack-työtilaan. Kirjautumisohjeet toimitetaan ennen koulutuksen alkua.

## Moduuli 1: AI-avusteinen ohjelmistokehitys käytännössä - 2 pv

### AI kehittäjän työkaluna

- Mitä generatiivinen AI ja LLM:t tarkoittavat käytännön ohjelmistokehityksessä
- Miten mallit tuottavat vastauksia ja miksi ne tekevät virheitä
- Kehittäjän roolin muutos: toteuttajasta ohjaajaksi, arvioijaksi ja laadunvarmistajaksi
- AI-natiivi kehitysmalli
- Promptauksen periaatteet ja hyvän promptin rakenne
- Projektikontekstin tekeminen AI:lle ymmärrettäväksi
- Kontekstin hallinta pitkissä tehtävissä

### Nykyiset AI-koodaustyökalut ja niiden valinta

- AI-työkalujen pääkategoriat: chat-pohjaiset, IDE-avustajat, agenttimäiset kehitysympäristöt
- Esimerkkityökalut: Claude (Code), GitHub Copilot, Cursor, Gemini, ChatGPT/Codex-tyylinen käyttö, IntelliJ IDEA AI
- Mallien välisistä eroista
- Claude Coden CLI perusteet

### Ohjelmakoodin tuottaminen AI:lla

- Erot uuden järjestelmän rakentamisen ja olemassa olevan koodin AI-modernisoinnin välillä
- Greenfield: AI suunnittelussa, alkutoteutuksessa, spesifikaatioiden tulkinnassa ja testien kerrostamisessa
- Brownfield: AI legacy-koodin ymmärtämisessä, refaktoroinnissa, dokumentoinnissa ja muutosriskien tunnistamisessa
- Claude Code: plan mode, muutosten hallinta, debuggaus, feature kehitys
- AI-avusteinen koodikatselmointi

### Spesifikaatio- ja testilähtöinen kehitys AI:n kanssa

- Testien generointi spesifikaatioista AI:n avulla
- Testit ohjurina AI-avusteisessa toteutuksessa
- AI:n tuottaman koodin validointi hyväksymiskriteerejä vasten
- Claude: Test and Evaluate, Develop Tests, Eval Tool

## Moduuli 2: AI sovelluksissa, agentteina ja tuotannossa - 2 pv

### AI sovelluksissa ja integraatiostrategiat

- Integraatiostrategioiden vertailu ja valinta: suorat API-kutsut, SDK-pohjainen integrointi, MCP-pohjainen työkaluyhteys.
- Pilvi- vs. paikalliset mallit ja hybridistrategiat
- Lokaalin pilvipalvelun asennus ja hyödyntäminen

### Tiedonhakuun perustuvat ratkaisut (RAG)

- RAG-ajattelu käytännössä
- Oman dokumentaation ja tietokantojen hyödyntäminen RAG:ssa.
- Milloin käyttää RAG vs suora konteksti
- Embeddings ja Files

### AI Agentit ja työkalujen käyttö

- Agenttiajattelu kehityksessä
- Moniagenttimalli
- LLM Tool Calling
  - Claude Tools
  - OpenAI Function Calling
- MCP (Model Context Protocol)

### CI/CD ja AI kehitysputkessa

- Perinteinen vs. AI-avusteinen pipeline
- Työstöstä tuotantoon: virheenkäsittely, reunatapaukset, suorituskyky
- AI:n rooli jokaisessa vaiheessa
  - Koodin generointi ja review
  - Testien automaattinen kirjoitus
  - Commit-viestit ja PR-kuvaukset
  - Pipeline-konfiguraatioiden ylläpito

### Workshop

- Osallistujan oman idean jalostaminen prototyypiksi tekoälyn avulla
- Prototyypin vieminen hallitusti kohti tuotantoa
  - Testaus, dokumentaatio, arkkitehtuuri
- Oman prototyypin esittely
