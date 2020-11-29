package com.smalldot.web;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static java.lang.String.format;

@SpringBootTest
public class PullTest {
    @Autowired
    RestTemplate restTemplate;
    static String URL_FIX = "http://ncpm.zhaopin.com/communityFix/fixByTaskId?taskId=%s";
    @Test
    void contextLoads() throws InterruptedException {
        String str = "，312448，312447，312444，312434，312458，312439，312454，312443，312456，312442，312438，312445，312452，312433，312435，312436，312457，312437，312446，312449，312455，312440，312441，312451，312453，316302，312459，316162，316159，316157，313435，317455，317454，316500，316347，316096，316787，312461，312460，303906，304315，304349，304175，302967，313437，313434，316344，316506，316498，316330，316480，316503，316479，316475，312450，312484，312483，312464，312472，312467，312462，312470，312468，312469，312463，312471，312482，316301，312476，314632，312478，312477，312481，312480，312479，312473，312474，312475，312546，312566，312548，312561，312582，312570，312530，312501，312533，312510，312542，312536，312513，312584，312583，312569，312531，312495，312502，312519，316788，312485，312486，312493，312520，316163，312547，312563，312565，312571，312572，312578，312544，312580，312511，312509，312534，312540，312527，312581，312579，312529，312517，312518，312503，312497，312504，316300，312487，312488，312494，312525，312539，312538，312524，312523，312514，312500，312498，312532，312573，312562，312545，312508，312507，316299，316165，316495，316155，316049，316048，312489，316445，312550，312567，312568，312574，312575，312576，312577，312585，312586，312549，312499，312512，312535，312543，312537，312505，312516，312588，312506，312521，312492，312496，312491，312526，312594，312599，312600，312601，312602，312593，312604，312606，312607，312609，312610，312611，312612，312613，312614，312615，312616，312617，312592，312619，312620，312589，312590，312591，312621，312597，312605，312608，312622，312628，312596，312630，312629，312632，312631，316296，312595，316295，312641，312640，312661，312655，312665，312675，312664，312671，312685，312688，312677，312676，316167，312623，312687，316494，312636，312635，312634，312646，312645，312644，316496，312662，312659，312654，312648，312647，312683，312672，312667，312666，312697，312696，312695，312686，316160，316166，316161，316158，312626，312625，312624，316047，312650，312649，312639，312638，316045，312660，312657，312653，312652，312651，312681，312680，312679，312691，312690，312689，312670，312663，312698，312700，312701，312702，312703，312704，312705，312706，312694，312627，312633，312637，312642，312643，312656，312658，312673，312668，312669，312674，312682，312684，312692，312693，312708，316164，312753，312709，312711，312712，312715，312716，312721，312722，312723，312724，312725，312729，312730，312732，312737，312738，312742，312743，312745，312746，312749，312750，312752，312756，312751，312760，312762，312713，312770，312780，312781，312739，312736，312717，312785，312792，312718，312719，312794，312800，312801，312720，312726，312728，312733，312807，312808，312809，312748，312747，312741，312763，312757，312755，312766，312765，312764，312779，312771，312767，312791，312790，312714，316497，312731，312727，312740，312734，312798，312797，312782，316926，313506，318701，316504，312758，316529，316531，316156，316046，317453，317451，312803，312802，312799，312793，312787，312786，312776，312775，312774，312773，312768，312759，317446，317447，317452，312769，312777，312778，312789，312795，312796，312804，312805，312806，312810，312811，312812，312813，312814，312815，312818，312819，312820，312821，312822，312823，312824，312825，312826，312929，312939，312887，312944，312940，312946，312886，312827，312836，312833，312849，312848，312945，312880，312897，312862，312861，312926，312918，312899，312913，312906，312898，312893，316530，312892，312830，312838，312839，312840，312841，312891，312850，312851，312882，312858，312859，312878，312852，312925，312860，312924，312919，312903，312909，312910，312914，312902，316533，312943，312942，312930，312890，312894，312900，312854，312908，312912，312855，312844，312843，312842，312832，312829，312922，312884，312885，312901，312907，312881，312831，312877，312879，312837，312835，312834，312853，312847，312889，312916，316150，312856，316052，312857，312846，312888，312896，312905，312917，312911，312895，312904，316592，316051，312963，312947，312952，312949，312950，312951，312964，312953，312954，312955，312956，312957，312958，312959，312970，312961，312962，312965，312966，312967，312972，312968，312973，312969，312971，313012，313009，313017，313026，313013，313007，312984，312991，312990，312998，313005，312983，313019，314580，312975，312982，312976，313034，313037，313046，313045，313006，313055，313047，313056，313000，313041，312999，312993，312992，312979，312977，312986，312985，313038，313032，313025，313053，313052，313049，313031，313024，313018，313008，316346，316491，316502，316509，316329，313002，313001，312995，312994，313022，313016，313015，312978，312988，312987，312981，313040，313011，313010，313039，313030，313054，313036，313042，313029，313023，316933，316446，316444，313020，312754，312761，313035，312772，313027，313028，312699，313021，312989，313043，313044，313058，313050，313048，313057，312997，312598，313051，313014，312744，313004，312564，313110，313239，312828，312816，313114，313113，313134，313150，313115，313129，313123，313155，313124，312996，312941，313112，313117，313116，313118，313111，313119，313120，313121，313122，316932，313158，313157，313156，313179，313164，313163，303977，304396，302969，317450，317449，316593，316332，316333，316499，316505，316331，316348，316473，316476，313218，313203，313197，313207，313205，313202，313159，313219，313232，313228，313241，313249，313248，312283，312285，316935，316345，316477，316481，316482，316508，316574，316572，316576，313208，313229，313230，313184，313210，313201，313209，313225，313198，313234，313195，313235，313204，313226，313236，313199，313227，313200，313238，313211，313212，313213，313214，313216，313215，313217，313253，313240，313243，312284，312287，303907，303938，304009，304221，304336，304363，304338，302972，316931，303948，304139，316478，316577，316492，316510，316575，316578，313251，313242，313250，313247，312286，304212，303009，304505，303562，304335，308228，303204，308310，316929，316447，318475，316501，316571，316573，318188，303838，303937，303976，312980，313233，313255，313256，313259，313262，313263，313264，313274，313266，313267，313268，313265，313270，313271，313261，313260，313273，313272，313277，313252，313423，303869，303915，304339，304244，304337，303297，303338，313467，313466，313462，313452，313445，313444，313441，313424，313461，303579，303577，304329，304501，304503，303201，303206，304144，304254，304282，313456，304397，304391，313447，303008，313471，313465，313460，313446，313440，313425，304419，302968，304504，302971，303300，303302，303203，318207，318208，313463，313453，313455，313454，304243，304283，304383，313449，304502，313448，313442，304515，303000，313469，313468，313464，313426，303205，303301，303339，303573，302998，303578，303617，304874，308228，316440，313483，313479，313480，313487，313433，313472，313470，313481，313478，313476，313477，313482，313443，313457，313458，313459，313492，313474，313484，313490，313597，313603，313611，313612，313618，313577，313586，313591，313593，313552，313550，313563，313564，313570，313571，313528，313536，313537，313546，313527，313538，313507，313508，313516，313517，313598，313607，313578，313588，313592，313594，313595，313596，313549，313559，313560，313561，313548，313569，313576，313525，313531，313534，313535，313547，313523，313513，313494，313515，313610，313573，313497，313601，313606，313608，313614，313615，313616，313572，313583，313585，313587，313554，313590，313555，313565，313566，313551，313530，313540，313541，313529，313519，313526，313623，313575，313602，313605，313582，313553，313556，313557，313599，313589，313574，313558，313568，313545，313522，313532，313533，313539，313542，313543，313521，313518，313509，313510，313511，313512，313609，313643，302999，313670，313635，313624，313613，308230，313662，313660，313671，313653，313642，313630，313629，304529，304213，313652，313644，313693，313692，313685，313678，313677，313631，303001，313651，313637，313681，313626，313620，313619，313617，303276，313675，313674，313632，303257，303202，316603，313689，313688，313666，313682，313665，313659，313658，313627，313622，303259，303609，313676，313669，313668，302970，313667，303277，308155，303331，313691，313690，313684，313683，313661，313655，313654，313641，313634，313633，313702，313705，313706，313703，313707，313672，313673，313679，313686，313687，313700，313699，313694，313663，313680，313696，313698，313697，313695，313704，313628，313657，313650，313656，313710，303608，313761，313745，313767，313708，313774，313775，313781，313782，313783，313790，313794，313795，313803，313804，313814，313815，313709，313822，313823，313831，313832，313840，313726，313735，303328，318437，316728，313764，313744，313771，313784，313785，313711，313791，313801，313717，313808，313811，313812，313813，313819，313820，313828，313829，313718，313724，313721，313739，313725，313734，318413，313763，313729，313769，313731，313770，313776，313777，313778，313786，313787，313793，313796，313712，313797，313805，313806，313816，313723，313825，313826，313834，313835，313842，313844，313736，313742，313728，313727，313765，313748，313766，313772，313773，313779，313780，313788，313713，313792，313798，313799，313800，313807，313809，313810，313714，313719，313733，313737，313732，313738，313891，313881，313908，313846，313854，313855，313856，313860，313862，313861，313866，313871，313877，313879，313843，313887，313818，313824，313827，313833，313836，313837，313911，313902，313485，316938，313898，313899，313903，313906，313907，313913，313845，313848，313849，313857，313858，313859，313867，313868，313869，313875，313878，313888，313889，313890，313830，313914，313838，313839，316774，313883，313900，313897，313893，313892，308309，313847，313841，308896，308360，313864，313863，313851，313850，313880，313874，313872，313870，313916，313915，313909，313901，313884，316541，313896，313905，313910，313912，313895，313919，313920，313918，313922，313921，313923，313925，313924，313927，313928，313926，313853，313865，313873，313876，313882，313885，313886，313929，316507，314008，314009，314015，314018，314024，314034，313998，313951，313957，313958，313959，313975，313976，314000，313982，313943，313991，314002，313992，313941，313934，313935，313936，314036，313491，314007，314016，314025，314037，314039，314040，314050，314051，314061，313947，313955，313956，313966，313967，313973，313974，313980，313990，313996，313999，313944，313931，313932，314062，314006，314010，314011，314012，314013，314020，314021，314022，313952，313961，313963，313970，313977，313979，313985，313986，313993，313997，313950，313938，313933，313945，313946，314026，318190，314001，314014，314017，314019，314023，314030，314031，314032，314042，314043，313953，313987，313954，313964，313965，313971，313981，313972，313978，313949，313994，313995，313940，313948，308368，308325，308361，308363，308905，312229，318202，314057，314049，314059，314058，314048，314047，314041，314038，314033，314029，314028，314027，308366，308369，308352，308358，308357，308904，307007，314063，314060，314054，314053，314052，314046，314045，314044，313750，313749，313747，313746，313743，313730，313257，313254，313498，313196，312845，312817，313033，312788，312784，312783，313003，312735，312710，312707，312974，312960，312948，312678，312618，312603，304378，308328，308359，308898，306990，308370，311604，311583，311590，311600，307419，311584，311591，311598，308170，318205，318195，312587，312528，306820，314056，314055，314035，314005，314004，314003，313983，313969，313962，313904，313894，313636，314297，313625，313604，313584，313581，313580，314275，314270，314317，313989，313988，313984，313968，313942，313939，313937，313930，313917，313852，313821，313817，313802，313789，313768，313762，313269，313621，313600，313579，313567，313562，313544，313524，313520，313514，308324，303833，308903，307005，308371，311595，311586，311597，311602，307421，307375，311592，311585，307625，308384，311688，318198，313451，318199，314493，314499，314521，314490，314491，314492，314518，314516，314494，314520，314512，314513，314514，314515，314511，314526，314510，314508，314525，314517，314519，314524，314523，314489，314522，314641，314639，314614，314621，314527，314560，314591，314592，314594，314603，314611，314613，314642，314551，314561，314533，314562，314565，314633，314573，314620，314607，314608，314545，314612，314553，314631，314537，314630，314629，314628，314616，314583，314588，314593，314596，314599，314600，314606，314564，314640，314584，314617，314528，314547，314618，314570，314589，314538，314610，314556，314572，314531，314605，314549，314536，314546，314539，314601，314602，314555，314550，314535，314625，314557，314619，314558，314623，314566，314571，314567，314624，314568，314587，314609，314563，314597，314543，314542，314541，314569，314548，314595，314576，314575，314577，307004，314634，314615，314604，314598，314574，314622，314532，311606，314590，314544，314540，314498，318203，314530，314655，314658，314659，314660，314638，314665，314661，314626，314664，314692，314657，314662，314665，314694，314627，318402，314665，314666，311607，311582，311589，314669，314667，314667，311599，314666，311603，307373，311594，308381，308168，308260，308320，311576，318213，311588，314669，314667，311596，311601，307420，307626，307422，311581，314672，314672，314671，314671，314670，314666，311587，311593，308497，307006，311579，318210，314690，308195，308261，314668，314668，314668，308326，308364，308858，308895，314669，314691，314685，314684，314686，308861，308907，309023，308893，309048，307010，314693，308239，308238，307394，314695，314689，314697，314696，314688，314687，314683，314672，314671，314670，314670，312225，314809，307011，314987，314808，314656，314843，307393，314843，314986，314845，314845，314845，314844，314844，314844，314843，314985，314807，308308，314698，307008，307395，315008，314994，311662，310059，312233，308226，314988，315004，315010，314995，314999，314996，314998，315015，315016，315018，314989，314990，315009，314979，308312，310060，315013，315012，308224，312234，311664，308845，308848，308888，308917，315000，315007，315011，315006，315005，315001，314992，314993，315017，314978，311661，311668，308847，309009，308311，310097，312927，313419，313418，313496，318223，313231，316474，318224，318718，318248，318719，318212，318251，318217，318249，318250，318764，311667，311663，311665，308920，309059，310058，310055，308184，313413，313414，313415，313495，318228，318197，318231，318232，318230，318229，318189，318254，318214，318252，318253，311666，310527，308270，311660，308846，308889，308909，309013，308373，312928，318240，318241，318219，318192，318191，318218，318246，318215，318722，318220，308969，309015，309011，308353，310143，310096，310526，312541，313183，313416，313417，313741，318239，318222，318225，318226，318227，318233，318234，318235，318247，318236，318242，318238，318267，316628，318297，318298，318268，318269，318270，318281，318255，318295，318317，318314，318296，318316，318261，318315，318331，318329，318333，318349，318351，318332，318271，318352，318350，318305，316636，316723，318272，318292，318293，318257，318258，318256，318259，318278，318260，318291，318306，318308，318312，318309，318290，318326，318322，318310，318325，318327，318328，318338，318289，318378，318375，318279，318286，318285，318282，318287，318288，318300，318299，318301，318262，318374，318263，318264，318302，318265，318321，318304，318340，318323，318324，318303，318339，318334，313245，313244，308307，317445，318274，318276，318275，318277，318280，318283，318284，318243，318313，318319，318320，318346，318335，318330，318336，318337，318343，318348，318354，318355，314487，313420，313431，312863，311622，311618，311626，311619，311628，313640，313246，311630，316564，312274，316390，318371，318383，318379，318345，318368，318372，318373，318342，318344，318386，314982，308362，314502，308844，311615，313759，308864，308857，308859，308955，308940，308980，309046，309332，313752，312868，316525，316555，316524，308843，318353，318362，318363，318360，308365，308860，311631，313751，308899，313165，313430，313421，313429，313428，313427，313224，312873，311612，312272，318364，318376，318366，318367，318358，318388，318357，318356，318365，308897，312875，311624，311623，311644，313504，313439，313237，311641，308900，308906，308953，308863，308894，318411，318381，318380，318377，318426，318412，318403，318423，318424，318425，318408，318394，316338，313755，313757，313754，313648，318401，318391，318417，318399，318398，318444，318460，318461，318462，318464，318463，318465，318415，318466，318485，318400，318387，318442，318443，318416，318484，314636，314585，315002，315003，313753，314579，308856，308902，308901，308862，308952，314980，314506，314507，314496，314486，308954，309024，309014，308865，309451，313432，314586，314581，314559，308367，308167，314485，314504，314497，314495，310002，308323，310056，312515，312522，313503，313436，312280，314582，314635，314578，314984，314981，313438，308329，310088，310086，314983，314505，313760，313649，313639，313499，313500，312876，312867，316551，316523，316521，314997，315019，314663，314637，313756，315182，315181，313502，315180，315187，315188，315434，315433，314503，314501，315444，314552，313501，313505，314534，314488，314554，315190，308229，315205，307970，310001，315189，315191，309999，310057，308321，310089，310087，312883，313646，312869，311617，311621，313647，313638，313450，315195，315194，315193，308169，309998，310000，315192，315199，315198，315196，315203，308327，315204，308322，315208，312920，312281，312921，315197，312923，315201，315202，313275，313960，316552，317458，317448，318643，318651，318652，318653，318654，318655，318670，318674，318636，318390，318393，318680，318635，318667，315200，316431，313258，315210，315209，316590，315214，311610，313276，317456，316560，316561，313489，313486，316598，318395，313715，313488，318410，318396，318409，318392，318407，313645，314500，313740，313720，313716，313701，313493，313475，313664，313473，313206，312490，313422，312915，315183，315218，315219，315207，315215，315206，315212，315213，315220，315216，315263，315217，315184，315264，315238，314509，315014，314529，315211，315271，315265，315260，315274，315269，315272，315261，315262，315276，315275，315268，315277，315273，313722，315369，315371，315375，315377，315370，315372，315378，315429，315366，315367，315368，315373，315374，315376，315379，315431，315428，315432，315430，315443，315439，315435，315448，315446，315445，315442，315437，315436，315447，316443，317457，316585，316556，316596，316777，316740，316798，316737，315186，315427，315438，315440，316526，311647，311648，316739，316553，316522，316527，316594，316734，316796，316799，318404，316741，316749，316776，316794，318405，318406，318414，318397，314991，315441，315380，315185，315266，315325，315267，316100，316099，316094，316095，316102，316097，316587，316101，316098，316104，316103，303944，304250，303278，306616，306615，312466，308330，308334，308341，316554，316105，316591，316735，316595，316736，316797，316738，316747，316750，318419，302994，304443，316154，316152，316151，316147，308304，308332，308336，308351，307001，312228，312870，312864，316802，316106，316153，316149，316148，302995，303324，306613，306614，308231，308306，308339，308337，308342，308354，316795，304179，303873，303325，308302，308331，308335，308394，308391，308395，307000，312465，316304，316303，316305，308340，316334，308348，308390，308389，306986，311627，311611，316358，316410，316406，316405，316411，316412，316307，316306，308396，308397，306987，306999，312227，307002，307012，316351，316335，307974，311635，307612，316383，316385，307013，316349，312226，316408，318455，318441，316387，316396，316397，316398，316403，316404，316413，316409，316414，316418，318438，318421，318456，318440，318457，307003，316350，316392，311620，308187，311608，311636，316393，316407，316416，316417，316415，316401，316400，316391，311639，311609，308181，311625，311632，311646，311645，311633，318427，318474，318451，318422，318452，318453，318454，318429，311643，318428，311629，316421，316420，311634，316422，316434，311642，316435，308180，316436，318434，308235，318432，318433，318435，318430，318436，318445，318447，318431，318446，308151，316441，316439，316426，312119，316438，316428，316427，316437，317687，308185，308234，308868，317690，317688，317701，308152，311613，316442，308236，308233，311616，316448，316450，316451，316453，316455，316458，316459，316456，316460，316454，316461，316452，308272，311640，312118，316468，316462，316469，316484，316487，316488，316545，316546，316547，316652，316449，318493，318473，318492，318448，318449，318494，318491，318468，308385，316465，308338，316493，316463，316528，316490，316489，316466，316516，316518，316563，316559，316565，316517，318459，318467，318469，318458，308273，308305，308343，308375，316512，316513，308840，316514，316483，316486，316511，308333，308347，308838，308870，308878，316544，316536，316540，316467，316471，316537，316535，308349，308842，308880，308867，308872，316567，316550，316532，316570，316569，316568，316538，308881，308849，308874，308932，308882，308886，308921，308929，308922，316566，316543，308841，308869，316549，308876，316548，308890，308839，308925，308967，308937，308971，309018，309017，309063，310006，310003，311637，309628，316519，310083，310010，318480，318481，318470，318471，318472，308871，308879，308891，308873，308877，308875，308883，308885，316298，308931，308968，308930，308970，309019，316464，309016，309061，316470，316388，309333，308303，316562，316583，316584，308887，308866，308884，308911，308926，308966，316604，316606，316608，316610，316614，316616，316618，316620，316622，316623，316586，316589，316627，316624，316631，316629，316630，308927，308965，308936，308972，309020，309021，309328，308232，316588，316602，316607，316609，316611，316612，316613，316615，316617，316619，316621，316597，316625，316626，308933，308344，316649，308186，316648，316647，312558，312554，312552，310082，316557，316632，316642，318477，316643，318479，316803，318476，318644，318478，318645，318646，308345，308350，308393，308183，316640，310009，310015，318647，310005，309627，316558，316633，316637，310017，316644，318648，318483，308313，308346，310007，310004，310016，310014，316639，317704，317706，317810，310013，317715，316645，316634，316635，310011，317812，317703，317811，317725，316638，316641，317712，316654，316655，316650，316651，316653，316715，316724，316725，316656，316713，316714，316716，316718，317708，316721，316722，316727，317710，317711，308355，316756，308386，317718，316742，316743，316744，316785，316755，316762，316763，316772，316754，316775，316780，316781，316745，316786，316800，310008，316809，317714，308182，316766，317717，316759，316760，312551，316729，316730，316731，316732，316789，316733，316746，316748，316782，316753，316752，316764，316765，312872，318486，317722，317723，316812，316767，316757，316811，316769，318649，317815，312555，316758，316770，316779，312557，312553，316813，316768，316771，316778，316783，316784，316810，318488，318489，318490，317816，317817，318665，317689，316717，312559，312866，312865，312560，312556，312422，318666，316751，316804，316792，316791，318650，318495，317721，312874，318725，318497，318723，312871，318664，316726，316472，316457，318450，316808，316807，316805，318656，312937，312938，312933，316937，316927，318676，318677，318385，318657，318658，318659，318672，318675，318370，317820，317813，318679，316806，312931，316793，316605，316601，316600，316534，316485，316399，316925，316402，316395，316394，316936，317822，316928，316941，318384，312934，312935，316940，317814，317823，316386，316384，316382，316381，316380，316374，316373，316370，316368，316366，316365，316364，316361，316433，316354，316352，316328，316327，316325，316322，316320，316319，316379，316367，316360，316340，316326，316324，316317，316313，312932，318382，312936，317459，316924，318735，318752，318728，318753，318727，318757，317818，317819，316377，316376，316375，316372，316369，316363，316362，316357，316355，316353，316339，316337，316336，316323，316316，316312，316311，316308，316297，313758，311614，316720，316371，316359，316425，316432，316430，316429，316424，316423，316356，316343，316342，316341，316646，316773，318369，318273，318689，318684，318733，318690，318694，316321，316310，316309，316389，316801，316790，316719，318294，318739，318743，318744，318754，318761，318762，318766，318768，318769，318773，318775，318776，316318，316942，316930，316515，316599，303330，303299，316539，318742，318747，318749，318685，318692，318244，318693，318697，318750，318758，318751，318759，318763，316315，316939，316582，303329，316761，318634，318638，318640，318641，318642，318660，318661，318662，318663，318681，318682，318683，318698，318699，318639，318637，318687，318686，318700，316314，316934，316520，303298，316542，316419，316378，311605，318741，318688，318695，318748，318696，318756，318760，318767，318770，318771，318772，318774，318777，318778，318839，318854，318829，318815，318825，318832，318873，318807，318800，318841，318869，318793，318782，318837，318874，318811，318838，318842，318840，318844，318845，318783，318849，318787，318862，318791，318808，318804，318868，318779，318851，318858，318867，318850，318809，318872，318863，318802，318823，318788，318860，318814，318817，318824，318797，318806，318796，318835，318781，318795，318836，318846，318848，318801，318847，318864，318853，318843，318812，318805，318790，318827，318861，318826，318819，318789，318798，318794，318857，318856，318855，318852，318870，318866，318871，318732，318389，318780，318482，318813，318792，318908，318912，318914，318915，318916，318917，318745，318909，318734，318740，318720，318717，318691，318673，318496，318361，318307，318221，318216，310012，318918，318919，318920，318921，318923，318924，318929，318930，318931，318936，318755，318922，318925，318926，318927，318932，318933，318934，318935，318928，318937，318204，318487，318913，318911，318910，318865，318765，318746，311638，318731，318738，318726，318724，318721，318439，318420，318211，318209，318206，318196，318194，318418，318359，318347，318318，318193，318341，318311，318266，318245，318237，318201，318200，319650，319655，319659，319660，319654，319656，319657，319649，319658，319652，319653，319897，319661，319899，320027，320093，319900，320021，320086，320087，320088，320089，320099，320091，320092，320094，320095，320096，320097，320098，320100，320179，320180，320181，320182，320183，320184，320185，320187，320188，320189，320190，320192，320193，320194，320195，320196，320178，319651，320197，320101，320198，320201，320203，320205，320206，320207，320208，320209，320210，320211，320212，320213，320217，320232，320233，320234，320237，320251，320252，320253，320267，320270，320276，320277，320278，320231，320275，320199，320214，320220，320223，320224，320225，320236，320239，320243，320244，320245，320246，320260，320261，320264，320266，320272，320281，320259，320247，320202，320215，320218，320221，320222，320230，320235，320241，320240，320200，320216，320226，320228，320238，320242，320248，320249，320250，320254，320255，320256，320257，320258，320263，320265，320268，320271，320273，320274，320279，320229，320269，320227，320280，320282，320219，320204，320191，320186，319896，318828，318678，317821，317719，317707，320085，320090";
        String[]arr = str.split("，");
        Arrays.stream(arr).forEach(i->{
            if(StringUtils.isNotBlank(i)){
                Integer id = Integer.valueOf(i.trim());
                System.out.println(id);
                handle(id);
                try {
                    Thread.sleep(1000*30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(arr.length);
    }
 private void handle(Integer taskId) {
    String url = format(URL_FIX, taskId);
    HttpHeaders headers = new HttpHeaders();
    String token = "01efbfeb-e5e0-4007-afab-1ce14a2f3dc0";
    headers.add("token", token);
    HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
    ResponseEntity<String> resEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, String.class);
    System.out.println(resEntity);
}}
