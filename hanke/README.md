# Tekoälyavusteisen ohjelmistokehityksen opintojaksokokonaisuus

Kokonaisuus etenee tekoälyä hyödyntävästä ohjelmistokehityksestä
tekoälyominaisuuksien rakentamiseen ja edelleen agenttisten järjestelmien
suunnitteluun. Opintojaksojen välinen työnjako on seuraava:

| Näkökulma | AI-Assisted Software Engineering | Engineering AI-Enabled Applications | Agentic and Reliable AI Systems |
| --- | --- | --- | --- |
| Tekoälyn rooli | Kehittäjän ohjattava työväline | Sovelluksen yksittäinen ominaisuus tai komponentti | Rajattu agentti, joka ohjaa monivaiheista toimintaa |
| Työkalujen käyttö | Ohjelmointiagentti muokkaa koodia ja käyttää kehitystyökaluja kehittäjän valvonnassa | Kielimalli ehdottaa työkalukutsua; sovellus validoi ja suorittaa sen | Agentti valitsee sallituista työkaluista, ylläpitää tilaa ja etenee rajatussa toimintasilmukassa |
| Testaus ja arviointi | Ohjelmistomuutos validoidaan hyväksymiskriteereillä, testeillä ja katselmoinnilla | Yksittäisen tekoälyominaisuuden vastauksia arvioidaan toistettavalla aineistolla ja kriteereillä | Lopputulos, työkaluvalinnat, toimintaketju ja virheistä palautuminen arvioidaan |
| Turvallisuus ja vastuu | Kehittäjä suojaa lähdekoodin ja datan, tarkistaa alkuperän ja käyttöehdot sekä hyväksyy muutokset | Syötteet ja vastaukset validoidaan; epäluotettava sisältö ja häiriötilanteet hallitaan ominaisuuden tasolla | Käyttöoikeudet rajataan, työkalutuloksia käsitellään epäluotettavina ja merkittävät toimet hyväksytetään ihmisellä |
| Tuotantovalmius | Laadunvarmistettu ja versionhallittu ohjelmistomuutos | Yksittäisen ominaisuuden virheenkäsittely, lokitus sekä kustannus- ja vasteaikaseuranta | Agenttisen järjestelmän tuotantovalmiuden puuteanalyysi ja valitut kontrollit |
| Osaamisen näyttö | Tekoälyavusteisesti toteutettu ja validoitu ohjelmistomuutos | Rajatut RAG- ja työkalukutsuratkaisut sisältävä sovellus; toista ratkaisua syvennetään ja arvioidaan | Rajattu ja havainnoitava yhteen agenttiin perustuva järjestelmä, jossa on valitut kontrollit |

---

## AI-Assisted Software Engineering, 5 op

### Tavoite

Opintojakson tavoitteena on antaa opiskelijalle valmiudet hyödyntää
generatiivista tekoälyä systemaattisesti ja tarkoituksenmukaisesti osana
ohjelmistokehitystä.

Opintojakson suoritettuaan opiskelija:

- selittää suurten kielimallien keskeiset toimintaperiaatteet sekä tunnistaa
  niiden mahdollisuuksia, rajoitteita ja riskejä ohjelmistokehityksessä
- vertailee tekoälyavusteisia työskentelytapoja ja perustelee menetelmän
  valinnan ohjelmistokehitystehtävän perusteella
- määrittelee tehtävän vaatimukset, rajaukset ja hyväksymiskriteerit sekä
  valitsee ja rajaa tekoälylle annettavan kontekstin
- hyödyntää tekoälyä ohjelmiston toteutuksessa, testauksessa ja
  koodikatselmoinnissa sekä soveltaa samoja periaatteita olemassa olevan
  ohjelmiston ymmärtämiseen ja muuttamiseen
- arvioi ja validoi tekoälyn tuottamat ratkaisut määrittelyjen, testien,
  katselmoinnin ja versionhallinnan avulla
- perustelee, mistä ohjelmistokehittäjä vastaa, ja soveltaa tietoturvaa,
  tietosuojaa, tekijänoikeuksia, lisenssiehtoja ja jäljitettävyyttä koskevia
  käytäntöjä sekä tunnistaa saavutettavuuteen ja vinoumiin liittyviä riskejä.

### Sisältö

#### Generatiivinen tekoäly ohjelmistokehityksessä

Opiskelija selittää generatiivisen tekoälyn ja suurten kielimallien
toimintaperiaatteet ohjelmistokehittäjän tarvitsemalla tasolla. Käsiteltäviä
aiheita ovat muun muassa syöteyksiköt (tokenit), konteksti ja konteksti-ikkuna,
mallien todennäköisyyksiin perustuva eli probabilistinen käyttäytyminen,
vahvuudet ja rajoitukset sekä virheellisten tai epäluotettavien vastausten
syntyminen. Samalla opiskelija vertailee generatiivisen tekoälyn vaikutuksia
ohjelmistokehittäjän työhön sekä tapoja hyödyntää tekoälyavustimia ja
ohjelmointiagentteja (coding agents) ohjelmistokehitysprosessissa.

#### Tekoälyavusteisen kehittämisen työnkulut ja kontekstin hallinta

Opiskelija suunnittelee ja ohjaa tekoälyavusteisen ohjelmistokehitystehtävän.
Sisältö käsittelee tavoitteiden, vaatimusten, rajausten ja
hyväksymiskriteerien määrittelyä, tehtävien pilkkomista sekä projekti- ja
versionhallintatietovaraston (repository) kontekstin välittämistä tekoälylle.
Opiskelija harjoittelee suunnitelmapohjaista ja iteratiivista työskentelyä sekä
kontekstin hallintaa pidemmissä kehitystehtävissä. Huomiota kiinnitetään
siihen, mitä tietoa tekoäly tarvitsee tehtävän suorittamiseen. **Tarpeeton tai
vanhentunut konteksti voi heikentää työskentelyä.**

#### Tekoäly ohjelmiston toteutuksessa, ylläpidossa ja modernisoinnissa

Opiskelija hyödyntää tekoälyä sekä uuden ohjelmiston kehittämisessä että
olemassa olevien järjestelmien ylläpidossa ja muuttamisessa. Sisältö käsittelee
ohjelmiston ja lähdekoodin ymmärtämistä, uuden ominaisuuden suunnittelua ja
toteutusta, muutosten vaikutusten arviointia, virheiden etsintää,
refaktorointia, vanhan ohjelmakoodin (legacy code) modernisointia ja
dokumentointia. Opiskelija tarkastaa tekoälyn ehdottamat muutokset
versionhallinnan ja ohjelmistokehityksen tavallisten työkalujen avulla ennen
niiden hyväksymistä.

#### Määrittely- ja testilähtöinen tekoälyavusteinen kehittäminen

Opiskelija toteuttaa ohjelmistokehitysprosessin, jossa tehtävän määrittely,
hyväksymiskriteerit ja testit ohjaavat tekoälyavusteista toteutusta. Opiskelija
muuttaa vaatimuksia testattavaan muotoon, tuottaa ja arvioi testejä sekä
validoi toteutuksen määrittelyjä vasten. Sisältöön kuuluvat yksikkö-,
integraatio- ja hyväksymistestit, poikkeus- ja rajatapaukset sekä automaattisten
tarkistusten hyödyntäminen palautesilmukkana, jossa tekoäly pystyy suorittamaan
testin, havaitsemaan epäonnistumisen ja korjaamaan toteutusta.

#### Tekoälyavusteinen koodikatselmointi ja ohjelmiston laadunvarmistus

Opiskelija arvioi tekoälyn avulla ohjelmakoodin oikeellisuutta,
ymmärrettävyyttä, ylläpidettävyyttä, suorituskykyä, riippuvuuksia ja
tietoturvaa. Opiskelija arvioi kriittisesti sekä tekoälyn tuottamaa
ohjelmakoodia että sen tekemiä koodikatselmointihavaintoja. **Tekoälyn
tuottamaa ratkaisua tai arviota ei hyväksytä pelkästään uskottavan vastauksen
perusteella, vaan sen oikeellisuus osoitetaan ohjelmistoteknisin keinoin.**

#### Turvallinen ja vastuullinen tekoälyavusteinen ohjelmistokehitys

Opiskelija arvioi tekoälyavusteista ohjelmistokehitystä tietoturvan,
tietosuojan ja vastuullisuuden näkökulmista. Sisältö käsittelee
luottamuksellisen lähdekoodin ja organisaation tietojen käsittelyä,
tekoälypalveluille annettavaa dataa, ohjelmointiagenttien käyttöoikeuksia ja
komentojen suorittamista sekä generoitujen riippuvuuksien ja ulkoisten
kirjastojen tarkistamista. Opiskelija tarkistaa generoidun koodin alkuperän,
tekijänoikeudet ja lisenssiehdot, dokumentoi käytetyt lähteet ja muutokset sekä
tunnistaa tuotoksista saavutettavuuteen ja vinoumiin liittyviä riskejä. Lisäksi
tarkastellaan, miten tekoälyn autonomiaa voidaan rajata
ohjelmistokehitysprosessissa. **Vastuu tekoälyn tuottamien muutosten
hyväksymisestä säilyy ohjelmistokehittäjällä.**

---

## Engineering AI-Enabled Applications, 5 op

Opintojakso jatkaa AI-Assisted Software Engineering -opintojaksoa siirtämällä
näkökulman tekoälyn käyttämisestä ohjelmistokehittäjän työvälineenä tekoälyn
hyödyntämiseen osana rakennettavaa ohjelmistoa. Työskentely etenee kielimallin
integroinnista kontekstin hallintaan, tiedonhakuun ja työkalukutsuihin sekä
edelleen ratkaisun systemaattiseen arviointiin ja luotettavuuden
vahvistamiseen.

Opintojakso keskittyy tekoälyominaisuuksia sisältävien sovellusten suunnitteluun ja toteuttamiseen. Luotettavuutta, tietoturvaa ja arviointia käsitellään yhden mallikutsun tai yksittäisen tekoälyominaisuuden tasolla. Varsinaiset agenttiarkkitehtuurit, laajempi MCP:n hyödyntäminen, agenttien orkestrointi ja agenttijärjestelmien tuotantovalmiuden arviointi kuuluvat seuraavaan opintojaksoon.

### Tavoite

Opintojakson tavoitteena on antaa opiskelijalle valmiudet suunnitella ja
toteuttaa ohjelmistoja, joissa generatiivinen tekoäly toimii osana sovelluksen
toimintaa.

Opintojakson suoritettuaan opiskelija:

- vertailee tapoja integroida kielimalleja sovellukseen ja perustelee mallin,
  rajapinnan ja arkkitehtuurin valinnan
- toteuttaa tekoälyominaisuuden, jossa käytetään kielimallin
  ohjelmointirajapintaa, hallittua kontekstia ja validoitavia rakenteisia
  vastauksia
- yhdistää kielimallin sovelluksen omaan tai ulkoiseen tietoon tiedonhaun
  avulla ja toteuttaa sovelluksen hallitseman työkalukutsun
- määrittelee tehtäväkohtaiset onnistumiskriteerit ja arviointiaineiston sekä
  mittaa ratkaisun laatua, kustannuksia ja vasteaikaa
- analysoi generatiiviseen tekoälyyn perustuvan ominaisuuden
  ei-determinististä toimintaa sekä toteuttaa mekanismit sen testaamiseen,
  rajaamiseen ja valvontaan
- validoi ratkaisun syötteet ja vastaukset, soveltaa tietoturvaa, tietosuojaa
  ja jäljitettävyyttä koskevia käytäntöjä sekä tunnistaa saavutettavuuteen ja
  vinoumiin liittyviä riskejä.

### Sisältö

#### Kielimalli osana ohjelmistoarkkitehtuuria

Opiskelija käyttää kielimalleja ohjelmointirajapintojen (API) ja
ohjelmistokehityspakettien (SDK) avulla sekä sijoittaa kielimallin osaksi
sovellusarkkitehtuuria. Sisältö käsittelee mallin valintaa, pyyntöjen ja
vastausten rakennetta, tilan hallintaa, suoratoistoa, virheenkäsittelyä,
viivettä ja kustannuksia. Opiskelija vertailee pilvipohjaisia ja paikallisesti
suoritettavia malleja sekä perustelee, milloin generatiivinen tekoäly on
tarkoituksenmukainen osa ohjelmistoratkaisua ja milloin tehtävä kannattaa
ratkaista perinteisellä ohjelmakoodilla. **Generatiivisen tekoälyn käyttö on
perusteltava ratkaistavan ongelman vaatimusten perusteella.**

#### Kontekstin hallinta ja rakenteiset vastaukset

Opiskelija muodostaa kielimallille tarkoituksenmukaisen kontekstin ja käyttää
mallin tuottamaa tietoa osana ohjelmiston toimintaa. Sisältö käsittelee
järjestelmä- ja sovelluskohtaisia ohjeita, käyttäjän syötettä,
keskusteluhistoriaa, dynaamista kontekstia, kontekstin rajaamista ja
tiivistämistä sekä rakenteisten vastausten tuottamista ennalta määriteltyjen
tietorakenteiden mukaisesti. **Ratkaisun tavoitteena on tuottaa validoitavaa
ja ohjelmallisesti käsiteltävää tietoa kielimallin vapaamuotoisen tekstin
sijasta.**

#### Tiedonhaku, vektoriupotukset ja RAG

Opiskelija tuo sovelluksen omaa ja ulkoista tietoa kielimallin käyttöön.
Sisältö käsittelee vektoriupotuksia (embeddings), semanttista hakua,
dokumenttien pilkkomista, metadataa ja hakumenetelmiä (retrieval). Opiskelija
rakentaa hakua hyödyntävän generointiratkaisun (retrieval-augmented
generation, RAG) ja analysoi sen vaiheet tiedon käsittelystä hakutulosten
valintaan ja vastauksen muodostamiseen. Opiskelija vertailee hakupohjaisia
ratkaisuja suoraan kontekstiin, tietokantahakuihin ja muihin tapoihin tuoda
ajantasaista tai sovelluskohtaista tietoa kielimallin käyttöön. **RAG on yksi
mahdollinen arkkitehtuuriratkaisu, ei oletusarvoinen ratkaisu kaikkiin
tekoälysovelluksiin.**

#### Työkalukutsut ja tekoälyn yhdistäminen ohjelmiston toimintoihin

Opiskelija yhdistää kielimallin ohjelmiston toimintoihin ja ulkoisiin
palveluihin työkalukutsujen (tool calling tai function calling) avulla.
Sisältö käsittelee työkalujen kuvaamista, parametrien muodostamista ja
validointia, työkalukutsun suorittamista sovelluksessa sekä tulosten
palauttamista kielimallille. Harjoituksissa kielimalli yhdistetään esimerkiksi
sovelluksen omiin toimintoihin, tietokantaan tai ulkoiseen
ohjelmointirajapintaan. **Kielimallin ja deterministisen ohjelmakoodin työnjako
määritellään tietoisesti.** Opiskelija perustelee, mitkä päätökset voidaan antaa
mallille ja mitkä säilytetään sovelluslogiikan hallinnassa.

Opiskelija toteuttaa sekä rajatun tiedonhakua hyödyntävän generointiratkaisun
että rajatun työkalukutsuratkaisun. **Opintojakson projektissa opiskelija
syventää valintansa mukaan yhtä näistä kahdesta aiheesta.**

#### Tekoälysovellusten testaus ja arviointi

**Arviointi kohdistuu yksittäisen tekoälyominaisuuden tuottamiin vastauksiin.**
Opiskelija muodostaa arviointiaineistoja ja testitapauksia sekä
määrittelee sovellukselle tehtäväkohtaiset onnistumiskriteerit. Sisältö
käsittelee determinististen ohjelmistotestien lisäksi generatiivisten
vastausten arviointia, vertailuvastauksia, automaattista arviointia, ihmisen
tekemää arviointia ja mallipohjaista arviointia. Opiskelija tunnistaa
regressioita sekä mittaa laatua, kustannuksia ja vasteaikaa kokonaisuutena.
Tavoitteena on siirtyä yksittäisten esimerkkikehotteiden kokeilemisesta
toistettavaan ja mitattavaan tekoälysovellusten arviointiin.

#### Tekoälysovellusten luotettavuus, tietoturva ja tuotantovalmius

**Opiskelija suunnittelee luotettavuus- ja tietoturvakontrollit yksittäisen
mallikutsun tai tekoälyominaisuuden tasolle.** Sisältö käsittelee syötteiden ja
mallin tuottamien vastausten validointia sekä käyttäjän syötteessä tai haetussa aineistossa
olevia kehoteinjektiohyökkäyksiä (prompt injection), jotka voivat vaikuttaa
yksittäiseen vastaukseen. Lisäksi käsitellään luottamuksellisen tiedon
käsittelyä, käyttöoikeuksia sekä yhden mallikutsun tai tekoälyominaisuuden
virheenkäsittelyä, aikakatkaisuja, uudelleenyrityksiä ja vaihtoehtoisia
toimintatapoja tekoälypalvelun epäonnistuessa. Opiskelija seuraa
syöteyksiköiden käyttöä, kustannuksia ja vasteaikaa yksittäisen ominaisuuden
tasolla sekä määrittelee lokituksen, lähteiden jäljitettävyyden ja muut
tuotantoympäristön hallintamekanismit. Lisäksi opiskelija tunnistaa käyttäjälle
näkyvistä vastauksista saavutettavuuteen ja vinoumiin liittyviä riskejä.
Keskeisenä lähtökohtana on, että kielimallia käsitellään epävarmana
ohjelmistokomponenttina, jonka ympärille rakennetaan tarvittavat kontrollit ja
laadunvarmistus.

---

## Agentic and Reliable AI Systems, 5 op

Opintojakso jatkaa Engineering AI-Enabled Applications -opintojaksoa
siirtämällä näkökulman yksittäisistä tekoälyominaisuuksista kohti agenttisia ja
monivaiheisia tekoälyjärjestelmiä sekä niiden tuotantovalmiuden arviointia.
Työskentely etenee agentin roolin ja autonomian määrittelystä työkalujen, tilan
ja muistin yhdistämiseen sekä edelleen järjestelmän havainnointiin, arviointiin
ja tuotantovalmiuden tarkasteluun.

Opintojakso keskittyy erityisesti agenttisten järjestelmien arkkitehtuuriin,
MCP-pohjaisiin integraatioihin, agenttien turvallisuuteen, havainnoitavuuteen,
arviointiin ja tuotantokelpoisuuteen. Edellisen opintojakson luotettavuus-,
tietoturva- ja arviointikäytännöt laajennetaan yksittäisestä mallikutsusta tai
tekoälyominaisuudesta koko monivaiheiseen toimintaketjuun.

### Tavoite

Opintojakson tavoitteena on antaa opiskelijalle valmiudet suunnitella ja
toteuttaa agenttisia tekoälyjärjestelmiä, joissa kielimalli toimii osana
monivaiheista ohjelmistoprosessia ja käyttää ulkoisia työkaluja, tietolähteitä
ja palveluita tavoitteiden saavuttamiseksi.

Opintojakson suoritettuaan opiskelija:

- erottaa agentin tavallisesta kielimallikutsusta ja ennalta määritellystä
  työnkulusta sekä perustelee agenttisen ratkaisun tarkoituksenmukaisuuden
- vertailee agenttiarkkitehtuurien hyötyjä, kustannuksia ja monimutkaisuutta
  sekä valitsee käyttötapaukseen sopivan arkkitehtuurin
- toteuttaa rajatun agenttisen järjestelmän, joka käyttää työkaluja, ylläpitää
  tilaa ja muistia sekä käsittelee virhetilanteet ja noudattaa lopetusehtoja
- hyödyntää Model Context Protocol -protokollaa (MCP) tai muuta perusteltua
  integraatiomekanismia järjestelmän yhdistämisessä ulkoisiin palveluihin
- määrittelee agentille vähimmät tarvittavat käyttöoikeudet,
  hyväksyntäpisteet ja muut autonomiaa rajaavat kontrollit
- toteuttaa järjestelmälle lokituksen ja jäljityksen sekä arvioi agentin
  toimintaa lopputuloksen ja toimintaketjun perusteella
- mittaa järjestelmän laatua, kustannuksia ja suorituskykyä sekä arvioi, mitä
  sen tietoturvalta, jäljitettävyydeltä ja luotettavuudelta vaaditaan
  tuotantokäytössä, ja toteuttaa arvioinnin perusteella valitut kontrollit.

### Sisältö

#### Agenttiset järjestelmät ja agenttinen ohjelmistokehitys

**Opiskelija erottaa agentin tavallisesta kielimallikutsusta ja ennalta
määritellystä ohjelmistotyönkulusta.** Sisältö käsittelee agentin tavoitteita,
päätöksentekoa, tehtävien pilkkomista, työkalujen valintaa, toimintojen
suorittamista ja tulosten hyödyntämistä seuraavissa vaiheissa. Opiskelija
vertailee deterministisiä työnkulkuja, tekoälyavusteisia työnkulkuja ja
autonomisempia agentteja sekä perustelee, missä tilanteissa agenttisuuden
lisääminen tuottaa hyötyä ja missä se kasvattaa tarpeettomasti järjestelmän
monimutkaisuutta.

#### Agenttien tila, muisti ja toimintasilmukat

Opiskelija ylläpitää monivaiheisen agentin tilaa, keskustelu- ja
tehtävähistoriaa sekä lyhyt- ja pitkäkestoista muistia. Sisältö käsittelee
tehtävän etenemisen seuraamista ja toimintasilmukoita, joissa agentti havainnoi
tilanteen, tekee päätöksen, käyttää työkalua ja arvioi saamansa tuloksen.
Opiskelija määrittelee lopetusehdot, aikarajat, toistojen
enimmäismäärät ja muut kontrollit, jotta agentin toiminta pysyy rajattuna ja
ennakoitavana.

#### Agenttiarkkitehtuurit ja orkestrointi

Opiskelija vertailee tapoja rakentaa agenttisia järjestelmiä. Sisältö käsittelee
yksittäiseen agenttiin perustuvia ratkaisuja, orkestroija–työntekijä-
(orchestrator–worker) ja suunnittelija–suorittaja-malleja (planner–executor),
agenttien käyttämistä työkaluina, tehtävien välittämistä agentilta toiselle sekä
moniagenttiratkaisuja. Opiskelija arvioi arkkitehtuurien hyötyjä, kustannuksia
ja monimutkaisuutta sekä tunnistaa tilanteet, joissa yksi hyvin suunniteltu
agentti tai deterministinen työnkulku on tarkoituksenmukaisempi kuin useiden
agenttien muodostama järjestelmä. **Moniagenttiarkkitehtuureja käsitellään
vertailun ja perustellun arkkitehtuurivalinnan tasolla, eikä niiden
toteuttaminen ole pakollinen osa osaamisen näyttöä.**

#### MCP ja tekoälyjärjestelmien integraatiot

Opiskelija kuvaa Model Context Protocol -protokollan periaatteet ja
toteuttaa sen avulla tekoälyjärjestelmän integraation ulkoiseen tietolähteeseen,
työkaluun tai palveluun. Sisältö käsittelee MCP:n
asiakas–palvelin-arkkitehtuuria, työkalujen ja resurssien tarjoamista
tekoälyjärjestelmälle sekä MCP-palvelimen suunnittelua ja toteuttamista.
Opiskelija määrittelee integraation käyttöoikeudet ja luottamusrajat sekä
arvioi, miten organisaation järjestelmiä voidaan tarjota agentin käyttöön
hallitulla ja uudelleenkäytettävällä tavalla.

#### Agenttien turvallisuus, käyttöoikeudet ja ihmisen hyväksyntä

Opiskelija analysoi agenttisten tekoälyjärjestelmien tietoturva- ja
hallintariskejä. Sisältö käsittelee työkalujen käyttöoikeuksia, vähimpien
oikeuksien periaatetta (least privilege) sekä työkalun tai ulkoisen palvelun
palauttaman epäluotettavan sisällön käsittelyä. Tarkasteltaviin uhkiin kuuluvat
kehoteinjektiohyökkäykset, joissa epäluotettava sisältö ohjaa agentin seuraavaa
päätöstä tai työkalukutsua, sekä haitalliset tai virheelliset työkalukutsut.
Opiskelija rajaa agentin toimintaa ja toteuttaa ihmisen osallistumiseen
(human in the loop) ja hyväksyntäpisteisiin (approval gates) perustuvan
ratkaisun. **Merkittävät tai peruuttamattomat toiminnot edellyttävät ihmisen
hyväksyntää.** Opiskelija perustelee agentin autonomian järjestelmän
käyttötarkoituksen ja riskitason perusteella.

#### Agenttien havainnoitavuus ja arviointi

**Arviointi kohdistuu agentin lopputulokseen ja koko monivaiheiseen
toimintaketjuun.** Näin edellisen opintojakson yksittäisen
tekoälyominaisuuden arviointi laajenee agentin päätöksentekoon ja autonomiaan.
Sisältö käsittelee lokitusta, jäljitystä (tracing), työkalukutsujen ja
toimintaketjujen seuraamista, syöteyksikkö- ja kustannusseurantaa sekä poikkeavan
käyttäytymisen tunnistamista. Arvioinnissa tarkastellaan työkaluvalintoja,
tehtävän etenemistä ja virheistä palautumista. Opiskelija rakentaa testitapauksia
ja arviointeja järjestelmämuutosten mittaamiseen ja regressioiden havaitsemiseen.

#### Agenttisten tekoälyjärjestelmien tuotantovalmius

**Tuotantovalmiutta arvioidaan koko agenttisen järjestelmän, ei yksittäisen
ominaisuuden, tasolla.** Opiskelija tunnistaa prototyypin puutteet. Sisältö
käsittelee monivaiheisen toimintaketjun virheistä palautumista, osittain
suoritettujen toimintojen käsittelyä, aikakatkaisuja, uudelleenyrityksiä,
varajärjestelyjä (fallback), mallien ja palveluiden vaihtamista, suorituskykyä
ja vasteaikaa sekä kustannusten kertymistä työkalukutsujen ja
iteraatiokierrosten aikana. Opiskelija toteuttaa arvioinnin perusteella valitut
kontrollit. Lisäksi tarkastellaan tekoälyjärjestelmän versioinnin ja arviointien
liittämistä kehitys- ja julkaisuprosessiin, tuotantojärjestelmän jatkuvaa
seurantaa sekä tuotannosta saatavan tiedon hyödyntämistä järjestelmän laadun
parantamisessa.
