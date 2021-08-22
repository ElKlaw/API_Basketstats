package application.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements IMailService{
 
    @Autowired
    private JavaMailSender emailSender;
 
    public void sendSimpleMessage(
      String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("contact.sportstats@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
    
    public void sendInvitation(String to) throws Exception {
    	MimeMessage  message = emailSender.createMimeMessage();
    	
    	
        String textEmail = "<div id=\"message\">\r\n" + 
        		"   <meta>\r\n" + 
        		"   <title>Rejoins l'équipe Lmb Seniors 2 sur SportEasy !</title>\r\n" + 
        		"   <span style=\"color: #FFF; background-color: #FFF; font-size: 5px; display: none\">Rejoins l'équipe Lmb Seniors 2 sur SportEasy !</span>\r\n" + 
        		"   <table style=\"border-spacing: 0; width: 100%; border: 0\">\r\n" + 
        		"      <tbody>\r\n" + 
        		"         <tr>\r\n" + 
        		"            <td align=\"center\" style=\"padding: 0\">\r\n" + 
        		"               <table style=\"border-spacing: 0; background-color: #fff; width: 600px\">\r\n" + 
        		"                  <tbody>\r\n" + 
        		"                     <tr>\r\n" + 
        		"                        <td height=\"42\" style=\"background-color: #323232; padding: 0 20px 0 20px; height: 42px; font-family: Arial, sans-serif; width: 100%\">\r\n" + 
        		"                           <span style=\"height: 42px\">\r\n" + 
        		"                           <img alt=\"SportEasy\" src=\"http://img.mail.sporteasy.net/im/15915/9a6b55a58690607486c00cdd56c132902d25e94aa449093ab5a093f8818b8d98.png?e=ApJYOCR2mmCoKkWkbxZEgzR_bKAbBm1ylnEJSi3eNEk7HBtMCCf6d3ZgBDe9J9-ew7-wMEhjBJZ7cRooB1CplZAZFtkBDFuGY8kTvbcoU3Y7712Jj6YAftyY95QuTOoH_u2b7ZLXPW8rVEadlAK_iNhj5-D75IoVk7balLURCFqmQXDWToSWFAhhn9GKqBY0Cd5wTBn-R0UCfvIt95TqTVsW3-pZfCBRoK5RWdjTPoGfBEE_CDRJQDp3lt-5l7YAVbvj0AjKXgnrTUdmCQ\" style=\"display: block; border: 0; text-align: center\">\r\n" + 
        		"                           </span>\r\n" + 
        		"                        </td>\r\n" + 
        		"                     </tr>\r\n" + 
        		"                     <tr>\r\n" + 
        		"                        <td style=\"height: 45px; width: 100%; font-size: 25px; font-weight: bold; line-height: 48px; color: #fff; background-color: #0078B9; padding: 5px\">\r\n" + 
        		"                           <a href=\"http://r.mail.sporteasy.net/tr/cl/Og6QZlmpPx41i3YwBVBI2hor7NVhbj7b9mR7WdO_oDJOTVZEgQiX3tSbHiSlvZtayqNZcZmgRuo78MfWtgEcYwU_ZFm9FOZsRA8e8VAbi73GTrgHgaFRT1yJv83kIxs3ftIXlkQVztGtGE2NW4W5l-dgo4u1kpUhhhzzYwyhak3_qsY7BkIBWVIzDMIwO5hvAKn2SP1sg1p2AIbti5bZtUCMzCXFwpgd5syCCY6zNfp1wONtaAfKQcYA9HlosZ2marpnZXwd3NyiaZRsv1jrLIxHu9VlXWW1Yf9LHTu53nHjSE9iLVxeUJ2U4a3lg1T4E4oXZyer\" style=\"text-decoration: none; color: #fff\" target=\"_blank\">\r\n" + 
        		"                           <img align=\"left\" height=\"40\" src=\"http://img.mail.sporteasy.net/im/15915/b70cc1ebf713fcb2d6d7962c1966ca85dc0a97190839c11b1ab1e3a408693953.png?e=WgJXhkfm6UGdnRJlher_xFYWFnbm8AqA2LHEY9mUsZtykelxRR47uIvexvAG8_FPDbzCc3-VA0aoC9-wNedRpE4zlWtiTtxqPuFrazUJf4kO-ErdNeP9B_sGDCB2IfFRTPoBoZKF4wk34y_Z8YyukqfylcZI46-uQ5wADpeqCTxq77cmWh0p5XdIRVTL6pB_ctnUk5tSC3mzlPnjuVR4l3qlW7gfkvpRU0eENza2KBd-Tc8gP3JcYL3oPFOvoEjtZVenRwb7uzTqDawTbP_o5L3WKyEzaQMvMt-TIw7qo-nwarZ66fA3-w\" style=\"display: block; border: 0; text-align: center; margin-right: 10px; margin-right: 20px; background-color: #ffffff; padding: 5px;\">\r\n" + 
        		"                           Lmb Seniors 2\r\n" + 
        		"                           </a>\r\n" + 
        		"                        </td>\r\n" + 
        		"                     </tr>\r\n" + 
        		"                     <tr>\r\n" + 
        		"                        <td style=\"font-size: 14px; padding: 0 40px 20px 40px; border-right: solid 1px #DDD; border-left: solid 1px #DDD\">\r\n" + 
        		"                           <h1 style=\"test-align: left; text-align: center; margin: 40px 0; color: #0078B9\">\r\n" + 
        		"                              <span style=\"test-align: left; text-align: center; margin: 40px 0; color: #0078B9\">\r\n" + 
        		"                              Rejoins l'équipe Lmb Seniors 2 sur SportEasy !\r\n" + 
        		"                              </span>\r\n" + 
        		"                           </h1>\r\n" + 
        		"                           <p style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              <span style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              Bonjour Pierre,\r\n" + 
        		"                              </span>\r\n" + 
        		"                           </p>\r\n" + 
        		"                           <p style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              <span style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              L'équipe \"Lmb Seniors 2\" utilise désormais SportEasy, un site internet et une appli mobile qui vont faciliter la gestion de l'équipe, et vous permettre de refaire le match avec vos coéquipiers !\r\n" + 
        		"                              </span>\r\n" + 
        		"                           </p>\r\n" + 
        		"                           <p style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              <span style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              <strong>Pierre Michel</strong> vous demande de rejoindre l'équipe en cliquant sur le bouton ci-dessous. L'activation de votre compte ne prendra que quelques secondes.\r\n" + 
        		"                              </span>\r\n" + 
        		"                           </p>\r\n" + 
        		"                           <table style=\"border-spacing: 10px; border-collapse: separate; text-align: center\">\r\n" + 
        		"                              <tbody>\r\n" + 
        		"                                 <tr>\r\n" + 
        		"                                    <td style=\"padding: 0; width: 580px\">\r\n" + 
        		"                                       <table style=\"border-spacing: 0; font-size: 20px; font-weight: bold; -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; margin: auto; background-color: #0078B9\">\r\n" + 
        		"                                          <tbody>\r\n" + 
        		"                                             <tr>\r\n" + 
        		"                                                <td style=\"padding: 0\">\r\n" + 
        		"                                                   <a href=\"http://r.mail.sporteasy.net/tr/cl/GA1V6UYevqd-Th4pjuLhGltzF--CfNnfPJ3brB95uZACZbCvVGnSNXEDlenBXufWaq8NbEZ1icsx9nZiOfX_DA74GUvtn1wwOK5ych0htpLkRuHD0cLy1YDUIEVhJQjYfFTvaFHUXmxD2e2LUK79Kz5L8kNdaBxrZQm6RR9pKr3A59MwD5JLOU6nMeZrAIQ8oGacEntjyhXuW1Fx0GM2G75n29VGpZ3PnCnk4ihoxqMXAXaltxbuAVE6jxzTMcC7cVyNa9GCaI25-VCSvD98BTedbfsjZzLlBq23LIcTPpK4DfXaPIsg5qY3klyIqf_4JR8mzENGSNKpOLCahzQyDdKfxenvN9fDr7OtmcIbBhVBlw-1Vwb5dfWA943Oo4wgo4mQO8mmgRdasESTKUGIq2CMa39_p_pDso3Zjlue_74lBUP2mUE6_gQtYODTf5rICEef-5dn12yJtwdey-6hbT9EwYzzImMe7mWhB0sYRWM_qnM\" style=\"text-shadow: 1px 1px 1px #333; text-decoration: none; display: block; padding: 5px 15px; color: #fff\" target=\"_blank\"><span style=\"text-shadow: 1px 1px 1px #333; text-decoration: none; display: block; padding: 5px 15px; color: #fff\">Rejoindre mon équipe</span></a>\r\n" + 
        		"                                                </td>\r\n" + 
        		"                                             </tr>\r\n" + 
        		"                                          </tbody>\r\n" + 
        		"                                       </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                 </tr>\r\n" + 
        		"                              </tbody>\r\n" + 
        		"                           </table>\r\n" + 
        		"                           <p style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              <span style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              Grâce à SportEasy, vous pourrez depuis votre ordinateur ou votre mobile :\r\n" + 
        		"                              </span>\r\n" + 
        		"                           </p>\r\n" + 
        		"                           <ul style=\"text-align: left; line-height: 22px\">\r\n" + 
        		"                              <li>\r\n" + 
        		"                                 consulter le calendrier et les statistiques de l'équipe\r\n" + 
        		"                              </li>\r\n" + 
        		"                              <li>\r\n" + 
        		"                                 communiquer simplement avec vos coéquipiers\r\n" + 
        		"                              </li>\r\n" + 
        		"                              <li>\r\n" + 
        		"                                 répondre présent ou absent pour un match en 1 clic\r\n" + 
        		"                              </li>\r\n" + 
        		"                              <li>\r\n" + 
        		"                                 voter pour l'homme du match\r\n" + 
        		"                              </li>\r\n" + 
        		"                              <li>\r\n" + 
        		"                                 <a href=\"http://r.mail.sporteasy.net/tr/cl/zxFrzdhtjJBvG84pU6PJVqYVnd8Jl5Qo3ZEPrccE-gGarCT2kFEywM27pMCkA0GkLa1deAoqbsBUFDNdmoy6_rNH-sZX5DQAAVXXFauUPU2SmLQas7Ey7jTLpaqsiF67LxSf8-xcXah_wf9OnqOPDYzhCRxOHSXlu0SOk4Bf4nfB8ZF_QLD6yqTyfUL9efpZCAoweNX6FNoo9nV30aEL5Nyq1lLuKW7N-wER1WvTFftgY2gQB4INtEvn0R5OeWFNZTbzuY4Q7CKo9fgpeMhd82RshysQ35DZwrf24oiivFB8P1A96LIvSuL5mWbD3ggCpT3H64Jf7RDXVM3a6GvzuA\" style=\"text-decoration: underline; color: #0078B9\" target=\"_blank\">et plein d'autres fonctionnalités sympas</a>\r\n" + 
        		"                              </li>\r\n" + 
        		"                           </ul>\r\n" + 
        		"                           <p></p>\r\n" + 
        		"                           <p style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              <span style=\"text-align: justify; line-height: 22px\">\r\n" + 
        		"                              À très bientôt sur SportEasy !\r\n" + 
        		"                              </span>\r\n" + 
        		"                           </p>\r\n" + 
        		"                        </td>\r\n" + 
        		"                     </tr>\r\n" + 
        		"                     <tr>\r\n" + 
        		"                        <td style=\"background-color: #323232; height: 35px; padding: 0 20px 0 20px\">\r\n" + 
        		"                           <table style=\"border-spacing: 0; width: 100%; margin: 5px auto\">\r\n" + 
        		"                              <tbody>\r\n" + 
        		"                                 <tr style=\"background-repeat: no-repeat; width: 100%; font-size: 11px; color: #fff; height: 35px\">\r\n" + 
        		"                                    <td colspan=\"3\" style=\"padding: 0; width: 100%; text-align: center\">\r\n" + 
        		"                                       <a href=\"http://r.mail.sporteasy.net/tr/cl/m-HKcjEt8zOXDKih7A8AfshKihxE6Ugt1IAr6d_udBhZKkMmBovqBrTUGNEZi5Wmj3rxA3iPfQS_7kdw3va9Dp42_nmUUsAVHTBf87Z_jd5g3s2rq67H19bCwq21qPAt3MwRwjYCzmU2n2mF39na6IwYxBKGW0HIacber-ggpgquVz371fR3qMTnn74ibCGxjdaF1ZLKag4Lt-zkGx9kRN9YGLDdf0yvcNjc1KYkxXzoIWP2ObbAcXthwvAYhuWm-jFElwmMKbRYypOViCv7ubyEP3rwxFzL1XvGWQPhV0cxFLlzbv6Ia8Ec0rIIoGCnETiunJ4vT_kYFkPu9mZOUfmejFWR247RAiLVmateM_1eBUrUev0_NA3G4CrMVVd1ubF2ABUdFzqv-6M7NFg-xwycNKyU9nYBIqKEf43HpRolke9pJQMlSzZwFr3c3_Y5B6LnrgHxD2tW68iz28IqX4KTQJjMYvGobEZ0AotZFEiCKRHeLQ\" style=\"text-decoration: underline; color: #fff\" target=\"_blank\">\r\n" + 
        		"                                       Ça ne me concerne pas, je ne veux plus recevoir ces emails\r\n" + 
        		"                                       </a>\r\n" + 
        		"                                       &nbsp; - &nbsp;\r\n" + 
        		"                                       <a href=\"http://r.mail.sporteasy.net/tr/cl/QL90NWVrIAyc6peiEB43gfcbh3Ym2UHVD5OvPKZWzoMLnnSDelBfNV94KXxcASdwUhBj8fdG21lO_9L6QmsWLqVr6CGB-8lNlqnXZf8lpGkDUstCmXr6RfIKC14J3XB5si1vRQdzzstekxWnOZpBgP9wkxsz_J5VQehHnjuWckto_5giSnmuoeedEY25W3W-3-Bqg0mDd4nu3P6YfsnAFtMjSMHPXuNh6Dcu9RhJGW57XLqLYpPZFCxUgkFUA4ajlssBMDIT7AOkfwuXZMlpUAnQ0H0xlwtId08rBHy6EwDTa0krIejY9RQS8mhKT9fwXVsPDMyffyOa5mQ\" style=\"text-decoration: underline; color: #fff\" target=\"_blank\">Besoin d'aide ?</a>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                 </tr>\r\n" + 
        		"                                 <tr style=\"background-repeat: no-repeat; width: 100%; font-size: 11px; color: #fff; height: 35px\">\r\n" + 
        		"                                    <td style=\"padding: 0; line-height: 22px\">\r\n" + 
        		"                                       <a href=\"http://r.mail.sporteasy.net/tr/cl/TO0uTSM7KRsUel0sc2OxdFN_g_HlMb3FRqgaoGINl-IhlD4-oF0qhBg7-hu4DrnBUtsKI_bA6yCdItEdMZtoDHszGjjfSRwBvc21H6Wf0QsSzHIrlIhjpu0L-evH1GYe3u3CVv1lhN8GbUPWt0VvbRXuqRao5jneW9dOtleL7a9aVnW8KYNk06W87eedcc5kpSgi\" style=\"text-decoration: underline; color: #fff\" target=\"_blank\">\r\n" + 
        		"                                       <img align=\"left\" src=\"http://img.mail.sporteasy.net/im/15915/3387747df7fc2969934dc0845f7320bea9f5b9c86fe17b08232c687db37d370a.png?e=dlc_kav4p3PojwTYlFRqxIXo7rujna7vHZqPNF3xGCpjoNhVdTyPQ4f54uG5Ry7coWIPBkwIzBUgzMhg6JtgvtDaFqz8Wm6EmJYqWU-j54xTGzAh1_s37zgkqDb8gBmAxMqOsL7p7_W_uGWGtINweIOEOp0jjaxDx31P9icom6xp-Dw0KOXc5g3-_awjcS1LDONo1hjcILzqeV0pYmKQ1Ow7FVLfsTvNFYeuYy0_UaIJNY4cpAy_rahfEM8s-X5NRjXHem_4omRGIg\" style=\"display: block; border: 0; text-align: center\">\r\n" + 
        		"                                       <span style=\"padding-left: 8px; color: #fff\">Suivez-nous sur Facebook</span>\r\n" + 
        		"                                       </a>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                    <td style=\"padding: 0; line-height: 22px\">\r\n" + 
        		"                                       <a href=\"http://r.mail.sporteasy.net/tr/cl/TnH_cduXFDNYEQ4YI-EOyfsuPaiJzxPlvjysinXqo5GPUAts3GLk6OjhD3aGn-0kvZFnASoWoWmBo3kRNjLK98xZJCV5F5ZXRKVn7MW48fkxr_rkl5GXAZ8ZU-6qhqtficQCUmk_YqqVfie3pRqK2BvbOMASm3C3w-fVRvgalHVm-i4oEdOtz6x8rJklwQ\" style=\"text-decoration: underline; color: #fff\" target=\"_blank\">\r\n" + 
        		"                                       <img align=\"left\" src=\"http://img.mail.sporteasy.net/im/15915/f2b7f49012a00163862ceefe7188b9e786ecf26b893d1984e7fdcdd370e1067b.png?e=hqvf6nxPUNzHe_42Sv5a-9ioSsnVOqNUtDHwGIaDdNeKMZf8uyEjcas-Zs7c2ako0N0onkB0Q6qdOqu9xCk73wt1P7uA_JqXa3Bf-g9wbap6Xe6RKiUoFzv86Ka40SZTRm7atiV-CoZil2uJ_tnvmfaTJdD7uXdcdkG3xWLGOAE5zRntnVJ8MUtMPQhnl8z-AntYBa93aOc0BQhXKoUdp4i7WF7dMfJTL9hTNO0KBb-AtLBD7xx18XmMIf11Ghu79HaPQkZ-mJkA\" style=\"display: block; border: 0; text-align: center\">\r\n" + 
        		"                                       <span style=\"padding-left: 8px; color: #fff\">Suivez-nous sur Twitter</span>\r\n" + 
        		"                                       </a>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                    <td style=\"padding: 0; line-height: 22px\">\r\n" + 
        		"                                       <a href=\"mailto:?subject=Connaissez-vous%20SportEasy%20%3F&amp;body=Salut%20%21%0A%0AVous%20connaissez%20SportEasy%20%3F%20C%27est%20l%27appli%20web%20et%20mobile%20que%20j%27utilise%20avec%20mon%20%C3%A9quipe.%20Elle%20permet%20d%27envoyer%20des%20convocations%20en%201%20clic%2C%20de%20g%C3%A9rer%20les%20disponibilit%C3%A9s%20des%20joueurs%2C%20de%20rentrer%20toutes%20leurs%20stats%2C%20ou%20encore%20de%20prolonger%20les%20matchs%20hors%20des%20terrains%20%28vote%20pour%20l%27homme%20du%20match%2C%20forum...%29.%0A%0APour%20en%20savoir%20plus%2C%20regardez%20leur%20vid%C3%A9o%20et%20inscrivez-vous%20sur%20www.sporteasy.net.%0A%0AA%20bient%C3%B4t%20%21\" style=\"text-decoration: underline; color: #fff\" target=\"_blank\">\r\n" + 
        		"                                       <img align=\"left\" src=\"http://img.mail.sporteasy.net/im/15915/fcda5a027ce4abb09ef8907c2c112945d69114f7fcb42f003556773fa8f7b4e4.png?e=sPhPFtu8yxeu9BPbsVFUuZ0fIQnR3gWGIuHYMLHOAGbnZkR5OlWdtNmj_OLyKaohvhUx43VvkNYrNZeRGFXiZtggWhsYA78qba8UijyYGIKRXVIfHJmBJ8p1IoEtOnIkah3p3otCkbu2F4jSbXslTucBtaFoPF2OaU32SJ_YB8042uSes385AzGrzHOJh0rh5_CWUJyM_aUClE7TpicyGILykehwS8QVMKIhIunMv0Z2cyOcDXCo8zrGO_tsROWjSxDWaHQU0Q\" style=\"display: block; border: 0; text-align: center\">\r\n" + 
        		"                                       <span style=\"padding-left: 8px; color: #fff\">Parlez-en à vos amis !</span>\r\n" + 
        		"                                       </a>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                 </tr>\r\n" + 
        		"                              </tbody>\r\n" + 
        		"                           </table>\r\n" + 
        		"                        </td>\r\n" + 
        		"                     </tr>\r\n" + 
        		"                  </tbody>\r\n" + 
        		"               </table>\r\n" + 
        		"            </td>\r\n" + 
        		"         </tr>\r\n" + 
        		"      </tbody>\r\n" + 
        		"   </table>\r\n" + 
        		"   <img width=\"1\" height=\"1\" src=\"http://r.mail.sporteasy.net/tr/op/A3Sp--XO5TYNnJz5Knt1geTpaX6fWrj_6xKnE44eimizvOJuOwnDVhJulwZAE-u4_oMD79U8xRuPaITzg6vbjRPoYyxh8XLPzo9Q8WNzo_cx3jFCvgQzkOadt14X1c7YGw\" alt=\"\">\r\n" + 
        		"</div>";
        
        
        
        
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);
    	
    	try {
    		messageHelper.setFrom("contact.sportstats@gmail.com");
        	messageHelper.setTo(to); 
        	messageHelper.setSubject("Rejoins ton club Lamboisière Martin Basket sur Basketstats !"); 
        	messageHelper.setText(textEmail,true);
    		emailSender.send(message);
    	} catch (MailException e) {
        }
    }
}
