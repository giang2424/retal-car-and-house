// package au.gangi.app.config.jwt;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import java.io.Serializable;
// import java.util.Date;
// import java.util.function.Function;

// @Component
// public class JwtTokenUtil implements Serializable {

//     private static final long serialVersionUID = -2550185165626007488L;

//     @Value("${jwt.secret}")
//     private String secret;

//     @Value("${jwt.token.validity}")
//     private long tokenValidity;

//     // Retrieve username from jwt token
//     public String getUsernameFromToken(String token) {
//         return getClaimFromToken(token, Claims::getSubject);
//     }

//     // Retrieve expiration date from jwt token
//     public Date getExpirationDateFromToken(String token) {
//         return getClaimFromToken(token, Claims::getExpiration);
//     }

//     public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = getAllClaimsFromToken(token);
//         return claimsResolver.apply(claims);
//     }

//     // For retrieving any information from token we will need the secret key
//     private Claims getAllClaimsFromToken(String token) {
//         return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//     }

//     // Check if the token has expired
//     private Boolean isTokenExpired(String token) {
//         final Date expiration = getExpirationDateFromToken(token);
//         return expiration.before(new Date());
//     }

//     // Validate token
//     public Boolean validateToken(String token, UserDetails userDetails) {
//         final String username = getUsernameFromToken(token);
//         return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//     }

//     // Generate token for user
//     public String generateToken(UserDetails userDetails) {
//         return doGenerateToken(userDetails.getUsername());
//     }

//     private String doGenerateToken(String subject) {
//         return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + tokenValidity))
//                 .signWith(SignatureAlgorithm.HS512, secret).compact();
//     }
// }